package com.example.springtest.domain.interfaces;

import com.example.springtest.api.Model.PlacePutRequest;

public interface PlaceUpdateService {
    void updatePlace(Long id, PlacePutRequest placePutRequest);
}
