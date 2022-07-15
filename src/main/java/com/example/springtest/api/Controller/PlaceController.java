package com.example.springtest.api.Controller;

import com.example.springtest.api.Model.PlaceCreateRequest;
import com.example.springtest.api.Model.PlacePutRequest;
import com.example.springtest.domain.interfaces.PlaceCreateService;
import com.example.springtest.domain.interfaces.PlaceDeleteService;
import com.example.springtest.domain.interfaces.PlaceReadService;
import com.example.springtest.domain.interfaces.PlaceUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceController {

    private final PlaceCreateService placeCreateService;
    private final PlaceReadService placeReadService;
    private final PlaceUpdateService placeUpdateService;
    private final PlaceDeleteService placeDeleteService;

    public PlaceController(PlaceCreateService placeCreateService, PlaceReadService placeReadService, PlaceUpdateService placeUpdateService, PlaceDeleteService placeDeleteService) {
        this.placeCreateService = placeCreateService;
        this.placeReadService = placeReadService;
        this.placeUpdateService = placeUpdateService;
        this.placeDeleteService = placeDeleteService;
    }

    @PostMapping("/place-create")
    public Long createPlace(@RequestBody PlaceCreateRequest placeRequest) {
        return placeCreateService.getCreateResponse(placeRequest).getId();
    }

    @GetMapping("/place/")
    public String getPlace(@RequestParam Long id) {
        return placeReadService.getPlace(id).toString();
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
