package com.example.springtest.api.Controller;

import com.example.springtest.api.Model.PlaceCreateRequest;
import com.example.springtest.api.Model.PlacePutRequest;
import com.example.springtest.domain.interfaces.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PlaceController {

    private final PlaceCreateService placeCreateService;
    private final PlaceReadService placeReadService;
    private final PlaceUpdateService placeUpdateService;
    private final PlaceDeleteService placeDeleteService;
    private final PlaceFindService placeFindService;

    public PlaceController(PlaceCreateService placeCreateService, PlaceReadService placeReadService, PlaceUpdateService placeUpdateService, PlaceDeleteService placeDeleteService, PlaceFindService placeFindService) {
        this.placeCreateService = placeCreateService;
        this.placeReadService = placeReadService;
        this.placeUpdateService = placeUpdateService;
        this.placeDeleteService = placeDeleteService;
        this.placeFindService = placeFindService;
    }

    @PostMapping("/place/")
    public Long createPlace(@RequestBody PlaceCreateRequest placeRequest) {
        return placeCreateService.getCreateResponse(placeRequest).getId();
    }

    @GetMapping("/place/")
    public String getPlace(@RequestParam Long id) {
        return placeReadService.getPlace(id).toString();
    }

    @GetMapping("/place/find")
    public String findPlace(@RequestParam String placeName) {
        return placeFindService.find(placeName).toString();
    }

    @DeleteMapping("/place/")
    public void deletePlace(@RequestParam Long id) {
        placeDeleteService.deletePlace(id);
    }

    @PutMapping("/place/")
    public void updatePlace(@RequestParam Long id, @RequestBody PlacePutRequest placePutRequest) {
        placeUpdateService.updatePlace(id, placePutRequest);
    }
}
