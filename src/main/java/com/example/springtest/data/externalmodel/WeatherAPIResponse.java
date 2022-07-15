package com.example.springtest.data.externalmodel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class WeatherAPIResponse {
    public Location location;
    public Current current;
}