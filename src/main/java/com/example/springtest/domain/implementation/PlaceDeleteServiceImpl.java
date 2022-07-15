package com.example.springtest.domain.implementation;

import com.example.springtest.data.db.Repository.PlaceRepository;
import com.example.springtest.data.exception.LocationNotFoundException;
import com.example.springtest.domain.interfaces.PlaceDeleteService;
import org.springframework.stereotype.Service;

@Service
public class PlaceDeleteServiceImpl implements PlaceDeleteService {
    private final PlaceRepository placeRepository;

    public PlaceDeleteServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void deletePlace(Long id) {
        if(!placeRepository.existsById(id)) {
            throw new LocationNotFoundException();
        }
        placeRepository.deleteById(id);
    }
}
