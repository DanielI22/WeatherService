package com.example.springtest.api.Model;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@ToString
public class WeatherResponse {
    private String place;
    private String country;
    private String type;
    private String description;
    private double temperature;
    private double feelsLike;
    private double windSpeed;
}
