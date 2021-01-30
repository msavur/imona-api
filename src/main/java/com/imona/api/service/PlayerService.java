package com.imona.api.service;

import com.imona.api.model.request.PlayerCreateRequest;
import com.imona.api.model.request.PlayerUpdateRequest;
import com.imona.api.model.response.PlayerResponse;
import com.imona.api.model.response.PlayersResponse;
import com.imona.core.generic.GenericResponse;

public interface PlayerService {

    GenericResponse<PlayerResponse> getPlayer(Long playerId);

    GenericResponse<PlayersResponse> getAllPlayers();

    GenericResponse deletePlayer(Long playerId);

    GenericResponse createPlayer(PlayerCreateRequest request);

    GenericResponse updatePlayer(Long playerId, PlayerUpdateRequest request);
}
