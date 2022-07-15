package com.example.springtest.api.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlacePutRequest {
    private String placeName;
    private String countryName;
    private String typeName;
    private Double latitude;
    private Double longitude;
}
