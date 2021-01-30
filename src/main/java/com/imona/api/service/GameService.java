package com.imona.api.service;


import com.imona.api.model.request.FormCreateRequest;
import com.imona.api.model.response.GameResponse;
import com.imona.core.generic.GenericResponse;

public interface GameService {
    GenericResponse<GameResponse> getGame(Long movieId);

    GenericResponse<?> create(FormCreateRequest request);
}
