package com.example.springtest.domain.interfaces;

import com.example.springtest.api.Model.PlaceFindResponseModel;

import java.util.List;

public interface PlaceFindService {
    List<PlaceFindResponseModel> find(String placeName);
}
