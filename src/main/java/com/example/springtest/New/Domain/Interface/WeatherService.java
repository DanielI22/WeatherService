package com.example.springtest.New.Domain.Interface;


import com.example.springtest.New.API.Model.WeatherRequest;
import com.example.springtest.New.API.Model.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeatherResponse(String placeName, String country);
}
