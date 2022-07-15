package com.example.springtest.api.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class PlaceCreateRequest {
    private String placeName;
    private String countryName;
    private String typeName;
    private Double latitude;
    private Double longitude;
}
