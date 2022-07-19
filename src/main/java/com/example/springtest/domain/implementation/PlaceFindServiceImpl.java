package com.example.springtest.domain.implementation;

import com.example.springtest.api.Model.PlaceFindResponseModel;
import com.example.springtest.data.db.Repository.PlaceRepository;
import com.example.springtest.domain.interfaces.PlaceFindService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class PlaceFindServiceImpl implements PlaceFindService {
    private final PlaceRepository placeRepository;

    public PlaceFindServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    @Override
    public List<PlaceFindResponseModel> find(String placeName) {
       return placeRepository.findAllByName(placeName)
                        .stream()
                        .filter(Objects::nonNull)
                        .map(place -> PlaceFindResponseModel.builder()
                                .placeName(place.getName())
                                .typeName(place.getType().getTypeName())
                                .countryName(place.getCountry().getName())
                                .build())
                        .sorted(Comparator.comparing(PlaceFindResponseModel::getPlaceName)
                                .thenComparing(PlaceFindResponseModel::getCountryName))
//                            .sorted((PlaceFindResponseModel pl1, PlaceFindResponseModel pl2) ->
//                                   {
//                                      if(pl1.getPlaceName().compareTo(pl2.getPlaceName()) == 0) {
//                                          return pl1.getCountryName().compareTo(pl2.getCountryName());
//                                      }
//                                      return pl1.getPlaceName().compareTo(pl2.getPlaceName());
//                                   }
//                                   )
                        .collect(Collectors.toList());
    }
}
