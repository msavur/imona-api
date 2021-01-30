package com.game.imona.service;


import com.game.imona.model.request.FormCreateRequest;
import com.game.imona.model.response.GameResponse;
import com.imona.core.generic.GenericResponse;

public interface GameService {
    GenericResponse<GameResponse> getGame(Long movieId);

    GenericResponse<?> create(FormCreateRequest request);
}
