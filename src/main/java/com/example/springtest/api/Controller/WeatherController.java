package com.example.springtest.api.Controller;

import com.example.springtest.api.Model.WeatherRequest;
import com.example.springtest.domain.interfaces.WeatherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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