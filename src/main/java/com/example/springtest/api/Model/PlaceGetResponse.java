package com.example.springtest.api.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PlaceGetResponse {
    private String placeName;
    private String countryName;
    private String typeName;
    private Double latitude;
    private Double longitude;
}
