package com.example.virtusaweatherdemo.models;

public class WeatherDataResponse {
    Main main;

    public WeatherDataResponse(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return main;
    }
}
