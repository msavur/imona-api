package com.imona.api.controller;


import com.imona.api.controller.endpoint.CityEndPoint;
import com.imona.api.model.response.CitiesResponse;
import com.imona.api.service.CityService;
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
