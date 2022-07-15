package com.example.springtest.domain.interfaces;

import com.example.springtest.api.Model.PlaceCreateRequest;
import com.example.springtest.api.Model.PlaceCreateResponse;

public interface PlaceCreateService {

    PlaceCreateResponse getCreateResponse(PlaceCreateRequest placeCreateRequest);
}
