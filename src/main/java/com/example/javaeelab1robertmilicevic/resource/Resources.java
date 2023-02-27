package com.example.javaeelab1robertmilicevic.resource;

import jakarta.json.Json;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Produces;

public class Resources {

    @Produces
    public Jsonb createJsonB() {
        return JsonbBuilder.create();
    }
}
