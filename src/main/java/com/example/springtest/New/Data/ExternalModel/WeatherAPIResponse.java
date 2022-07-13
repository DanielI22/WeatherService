package com.example.springtest.New.Data.ExternalModel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class WeatherAPIResponse {
    public Location location;
    public Current current;
}