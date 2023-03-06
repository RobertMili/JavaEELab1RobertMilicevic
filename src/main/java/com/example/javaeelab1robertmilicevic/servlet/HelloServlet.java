//package com.example.javaeelab1robertmilicevic.servlet;
//
//import java.io.*;
//
//import com.example.javaeelab1robertmilicevic.MyBean;
//import jakarta.inject.Inject;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//@WebServlet(name = "helloServlet", urlPatterns = {"/hello-servlet","/hello"})
//public class HelloServlet extends HttpServlet {
//
//    @Inject
//    public MyBean myBean;
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//
//        String values = request.getParameter("q");
//        String head = request.getHeader("host");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("<div>" + values + "</div>");
//        out.println("<div>" + head + "</div>");
//        out.println("</body></html>");
//    }
//
//
//
//    public void destroy() {
//    }
//}