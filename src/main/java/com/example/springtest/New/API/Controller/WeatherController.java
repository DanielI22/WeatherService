package com.example.springtest.New.API.Controller;

import com.example.springtest.New.API.Model.WeatherRequest;
import com.example.springtest.New.Domain.Interface.WeatherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/weather")
    public String showWeather(@RequestBody WeatherRequest weatherRequest) {

        String placeName = weatherRequest.getPlace();
        String country = weatherRequest.getCountry();
        return weatherService.getWeatherResponse(placeName, country).toString();
    }
}