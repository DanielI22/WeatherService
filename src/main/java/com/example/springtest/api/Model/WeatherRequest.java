package com.example.springtest.api.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class WeatherRequest {
    private String place;
    private String country;
    private Boolean inFahrenheit;
}
