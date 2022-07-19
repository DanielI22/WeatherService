package com.example.springtest.api.Model;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@ToString
public class PlaceFindResponseModel {
    private String placeName;
    private String countryName;
    private String typeName;
}
