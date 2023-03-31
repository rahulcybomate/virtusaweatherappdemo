package com.example.virtusaweatherdemo.apis;

import com.example.virtusaweatherdemo.models.WeatherDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("weather")
    Call<WeatherDataResponse> get_weather_data(
            @Query("q") String q,
            @Query("appid") String appid
    );
}
