package com.example.springtest.domain.implementation;

import com.example.springtest.api.Model.PlaceCreateRequest;
import com.example.springtest.api.Model.PlaceCreateResponse;
import com.example.springtest.data.db.Entity.Country;
import com.example.springtest.data.db.Entity.Place;
import com.example.springtest.data.db.Entity.Type;
import com.example.springtest.data.db.Repository.CountryRepository;
import com.example.springtest.data.db.Repository.PlaceRepository;
import com.example.springtest.data.db.Repository.TypeRepository;
import com.example.springtest.data.exception.PlaceAlreadyExistException;
import com.example.springtest.domain.interfaces.PlaceCreateService;
import org.springframework.stereotype.Service;

@Service
public class PlaceCreateServiceImpl implements PlaceCreateService {
    private final PlaceRepository placeRepository;
    private final CountryRepository countryRepository;
    private final TypeRepository typeRepository;

    public PlaceCreateServiceImpl(PlaceRepository placeRepository, CountryRepository countryRepository, TypeRepository typeRepository) {
        this.placeRepository = placeRepository;
        this.countryRepository = countryRepository;
        this.typeRepository = typeRepository;
    }

    public PlaceCreateResponse getCreateResponse(PlaceCreateRequest placeCreateRequest) {
        if(placeRepository.findByNameAndCountryName(placeCreateRequest.getPlaceName(),
                placeCreateRequest.getCountryName()) != null) {
            throw new PlaceAlreadyExistException();
        }


        if(!countryRepository.existsByName(placeCreateRequest.getCountryName())) {
            Country country = new Country();
            country.setName(placeCreateRequest.getCountryName());
            countryRepository.save(country);
        }
        if(!typeRepository.existsByTypeName(placeCreateRequest.getTypeName())) {
            Type type = new Type();
            type.setTypeName(placeCreateRequest.getTypeName());
            typeRepository.save(type);
        }
        Place place = new Place();
        place.setName(placeCreateRequest.getPlaceName());
        place.setLatitude(placeCreateRequest.getLatitude());
        place.setLongitude(placeCreateRequest.getLongitude());
        place.setCountryId(countryRepository.findByName(placeCreateRequest.getCountryName()).getId());
        place.setTypeId(typeRepository.findByTypeName(placeCreateRequest.getTypeName()).getId());
        placeRepository.save(place);

        return PlaceCreateResponse.builder().id(place.getId()).build();
    }
}
