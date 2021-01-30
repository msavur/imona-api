package com.game.imona.service;


import com.game.imona.model.response.CitiesResponse;
import com.imona.core.generic.GenericResponse;

public interface CityService {
    GenericResponse<CitiesResponse> getAllCities();
}
