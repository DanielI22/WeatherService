package com.example.springtest.domain.implementation;

import com.example.springtest.api.Model.WeatherResponse;
import com.example.springtest.data.db.Entity.Place;
import com.example.springtest.data.db.Repository.PlaceRepository;
import com.example.springtest.data.externalmodel.WeatherAPIResponse;
import com.example.springtest.domain.interfaces.RestTemplateProvider;
import com.example.springtest.domain.interfaces.WeatherService;
import com.example.springtest.data.exception.PlaceNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


@Service
@Primary
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplateProvider restTemplateProvider;
    private final PlaceRepository placeRepository;

    public WeatherServiceImpl(RestTemplateProvider restTemplateProvider, PlaceRepository placeRepository) {
        this.restTemplateProvider = restTemplateProvider;
        this.placeRepository = placeRepository;
    }


    public WeatherResponse getWeatherResponse(String placeName, String country, Boolean inFahrenheit) {

        Place place = placeRepository.findByNameAndCountryName(placeName, country);
        String url = "http://api.weatherapi.com/v1/current.json?key=ba2283c6c3a149a896690218220807&q="+place.getLatitude() +","+place.getLongitude();
        WeatherAPIResponse weatherAPIResponse =  restTemplateProvider.
                getRestTemplate().
                getForObject(url, WeatherAPIResponse.class);


        return   Stream.of(place)
                .map(pl -> restTemplateProvider
                    .getRestTemplate()
                    .getForObject(url, WeatherAPIResponse.class))
                .filter(Objects::nonNull)
                .map(pl -> {
                    assert weatherAPIResponse != null;
                    return WeatherResponse.builder()
                        .place(place.getName())
                        .country(place.getCountry().getName())
                        .type(place.getType().getTypeName())
                        .description(weatherAPIResponse.getCurrent().getCondition().getText())
                        .temperature(weatherAPIResponse.getCurrent().getTemp_c())
                        .feelsLike(weatherAPIResponse.getCurrent().getFeelslike_c())
                        .windSpeed(weatherAPIResponse.getCurrent().getWind_kph())
                        .build();
                })
                .peek(weatherResponse -> {
                        if(inFahrenheit) {
                            weatherResponse.setTemperature(weatherResponse.getTemperature()*9/5 + 32);
                            weatherResponse.setFeelsLike(weatherResponse.getFeelsLike()*9/5 + 32);
                        }
                    }
                )
                .findFirst()
                .orElseThrow();
    }
}
