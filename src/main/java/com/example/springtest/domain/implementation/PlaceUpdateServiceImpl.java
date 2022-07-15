package com.example.springtest.domain.implementation;

import com.example.springtest.api.Model.PlacePutRequest;
import com.example.springtest.data.db.Entity.Country;
import com.example.springtest.data.db.Entity.Place;
import com.example.springtest.data.db.Entity.Type;
import com.example.springtest.data.db.Repository.CountryRepository;
import com.example.springtest.data.db.Repository.PlaceRepository;
import com.example.springtest.data.db.Repository.TypeRepository;
import com.example.springtest.data.exception.LocationNotFoundException;
import com.example.springtest.domain.interfaces.PlaceUpdateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceUpdateServiceImpl implements PlaceUpdateService {
    private final PlaceRepository placeRepository;
    private final CountryRepository countryRepository;
    private final TypeRepository typeRepository;

    public PlaceUpdateServiceImpl(PlaceRepository placeRepository, CountryRepository countryRepository, TypeRepository typeRepository) {
        this.placeRepository = placeRepository;
        this.countryRepository = countryRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public void updatePlace(Long id, PlacePutRequest placePutRequest) {
        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()) {
            throw new LocationNotFoundException();
        }

        if(!countryRepository.existsByName(placePutRequest.getCountryName())) {
            Country country = new Country();
            country.setName(placePutRequest.getCountryName());
            countryRepository.save(country);
        }
        if(!typeRepository.existsByTypeName(placePutRequest.getTypeName())) {
            Type type = new Type();
            type.setTypeName(placePutRequest.getTypeName());
            typeRepository.save(type);
        }

        place.get().setName(placePutRequest.getPlaceName());
        place.get().setLatitude(placePutRequest.getLatitude());
        place.get().setLongitude(placePutRequest.getLongitude());
        place.get().setCountryId(countryRepository.findByName(placePutRequest.getCountryName()).getId());
        place.get().setTypeId(typeRepository.findByTypeName(placePutRequest.getTypeName()).getId());
        placeRepository.save(place.get());
    }
}
