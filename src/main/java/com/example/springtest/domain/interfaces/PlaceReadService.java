package com.example.springtest.domain.interfaces;

import com.example.springtest.api.Model.PlaceGetResponse;

public interface PlaceReadService {
    PlaceGetResponse getPlace(Long id);
}
