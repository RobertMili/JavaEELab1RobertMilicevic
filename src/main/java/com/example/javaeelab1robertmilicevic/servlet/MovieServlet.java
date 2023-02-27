package com.example.javaeelab1robertmilicevic.servlet;


import com.example.javaeelab1robertmilicevic.MyBean;
import com.example.javaeelab1robertmilicevic.entity.Movie;
import com.example.javaeelab1robertmilicevic.repository.MovieRepository;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="movieServlet", value = "/movies/*")
public class MovieServlet extends HttpServlet {

    @Inject
    MovieRepository repository;

    @Inject
    Jsonb jsonb;
    @Inject
    private MyBean myBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if (path == null || path.equals("/")) {
            resp.setContentType("text/html");

            PrintWriter out = resp.getWriter();
            out.println("<html><body>");

            out.println("<h1>" + "Movies" + "</h1>");
            out.println("<h1>" + path + "</h1>");

            for (Movie movies : repository.findAll())
                out.println("<div>" + movies.getId() + " : " + movies.getName() + "</div>");
            out.println("</body></html>");
        } else {
            long id = Long.parseLong(path.substring(1));
            var movies = repository.findOne(id);
            resp.setContentType("application/json");
            if (movies.isPresent()) {
                PrintWriter out = resp.getWriter();
                out.println(jsonb.toJson(movies));

            } else {
                resp.setContentType("text/html");
                resp.sendError(404);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();

        String line = null;

        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
            jb.append(line);
        } catch (Exception e) {
            Movie movie = jsonb.fromJson(jb.toString(),Movie.class);

            repository.insertFood(movie);
        }
    }
}
