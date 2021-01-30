package com.imona.api.service;

import com.imona.api.model.response.CitiesResponse;
import com.imona.core.generic.GenericResponse;

public interface CityService {
    GenericResponse<CitiesResponse> getAllCities();
}
