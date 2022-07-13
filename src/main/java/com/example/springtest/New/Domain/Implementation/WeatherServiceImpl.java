package com.example.springtest.New.Domain.Implementation;

import com.example.springtest.New.API.Model.WeatherResponse;
import com.example.springtest.New.Data.DB.Entity.Place;
import com.example.springtest.New.Data.DB.Repository.PlaceRepository;
import com.example.springtest.New.Data.ExternalModel.WeatherAPIResponse;
import com.example.springtest.New.Domain.Interface.RestTemplateProvider;
import com.example.springtest.New.Domain.Interface.WeatherService;
import com.example.springtest.New.Exception.LocationNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplateProvider restTemplateProvider;
    private final PlaceRepository placeRepository;

    public WeatherServiceImpl(RestTemplateProvider restTemplateProvider, PlaceRepository placeRepository) {
        this.restTemplateProvider = restTemplateProvider;
        this.placeRepository = placeRepository;
    }


    public WeatherResponse getWeatherResponse(String placeName, String country) {

        Place place = placeRepository.findByNameAndCountryName(placeName, country);
        if(place == null) throw new LocationNotFoundException();

        String url = "http://api.weatherapi.com/v1/current.json?key=ba2283c6c3a149a896690218220807&q=";
        WeatherAPIResponse weatherAPIResponse =  restTemplateProvider.
                getRestTemplate().
                getForObject(url +place.getLatitude() +","+place.getLongitude(), WeatherAPIResponse.class);

        assert weatherAPIResponse != null;

        return WeatherResponse.builder().
                place(place.getName()).
                country(place.getCountry().getName()).
                type(place.getType().getTypeName()).
                description(weatherAPIResponse.getCurrent().getCondition().getText()).
                temperature(weatherAPIResponse.getCurrent().getTemp_c()).
                feelsLike(weatherAPIResponse.getCurrent().getFeelslike_c()).
                windSpeed(weatherAPIResponse.getCurrent().getWind_kph()).
                build();
    }
}
