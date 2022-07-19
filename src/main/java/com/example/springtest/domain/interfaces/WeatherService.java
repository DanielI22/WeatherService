package com.example.springtest.domain.interfaces;


import com.example.springtest.api.Model.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeatherResponse(String placeName, String country, Boolean inFahrenheit);
}
