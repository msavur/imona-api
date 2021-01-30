package com.game.imona.controller;


import com.game.imona.controller.endpoint.CityEndPoint;
import com.game.imona.model.response.CitiesResponse;
import com.game.imona.service.CityService;
import com.imona.core.generic.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "http://localhost:3000")
public class CityController {

    private final CityService cityService;

    @GetMapping(value = CityEndPoint.GET_ALL_CITIES)
    public GenericResponse<CitiesResponse> getAllCities() {
        return cityService.getAllCities();
    }
}
