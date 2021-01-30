package com.game.imona.service;

import com.game.imona.model.request.PlayerCreateRequest;
import com.game.imona.model.request.PlayerUpdateRequest;
import com.game.imona.model.response.PlayerResponse;
import com.game.imona.model.response.PlayersResponse;
import com.imona.core.generic.GenericResponse;

public interface PlayerService {

    GenericResponse<PlayerResponse> getPlayer(Long playerId);

    GenericResponse<PlayersResponse> getAllPlayers();

    GenericResponse deletePlayer(Long playerId);

    GenericResponse createPlayer(PlayerCreateRequest request);

    GenericResponse updatePlayer(Long playerId, PlayerUpdateRequest request);
}
