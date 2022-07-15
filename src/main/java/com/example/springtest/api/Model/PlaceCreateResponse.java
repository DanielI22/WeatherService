package com.example.springtest.api.Model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
public class PlaceCreateResponse {
    private Long id;
}
