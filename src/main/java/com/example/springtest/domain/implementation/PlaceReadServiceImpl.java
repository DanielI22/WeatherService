package com.example.springtest.domain.implementation;

import com.example.springtest.api.Model.PlaceGetResponse;
import com.example.springtest.data.db.Entity.Place;
import com.example.springtest.data.db.Repository.PlaceRepository;
import com.example.springtest.data.exception.LocationNotFoundException;
import com.example.springtest.domain.interfaces.PlaceReadService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceReadServiceImpl implements PlaceReadService {
    private final PlaceRepository placeRepository;

    public PlaceReadServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public PlaceGetResponse getPlace(Long id) {
        Optional<Place> place = Optional.ofNullable(placeRepository.findById(id).orElseThrow(LocationNotFoundException::new));

        if(place.isPresent()) {
            return PlaceGetResponse.builder().placeName(place.get().getName()).
                    latitude(place.get().getLatitude()).
                    longitude(place.get().getLongitude()).
                    countryName(place.get().getCountry().getName()).
                    typeName(place.get().getType().getTypeName()).
                    build();
        }
        else {
            throw new LocationNotFoundException();
        }
    }
}
