package com.game.imona.controller;


import com.game.imona.controller.endpoint.PlayerEndPoint;
import com.game.imona.model.request.PlayerCreateRequest;
import com.game.imona.model.request.PlayerUpdateRequest;
import com.game.imona.model.response.PlayerResponse;
import com.game.imona.model.response.PlayersResponse;
import com.game.imona.service.PlayerService;
import com.imona.core.generic.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "http://localhost:3000")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping(value = PlayerEndPoint.GET_PLAYER)
    public GenericResponse<PlayerResponse> getPlayer(@PathVariable("playerId") Long playerId) {
        return playerService.getPlayer(playerId);
    }

    @GetMapping(value = PlayerEndPoint.GET_ALL_PLAYERS)
    public GenericResponse<PlayersResponse> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @DeleteMapping(value = PlayerEndPoint.GET_PLAYER)
    public GenericResponse deletePlayer(@PathVariable("playerId") Long playerId) {
        return playerService.deletePlayer(playerId);
    }

    @PostMapping(value = PlayerEndPoint.CREATE_PLAYER)
    public GenericResponse createPlayer(@RequestBody PlayerCreateRequest request) {
        return playerService.createPlayer(request);
    }

    @PutMapping(value = PlayerEndPoint.UPDATE_PLAYER)
    public GenericResponse updatePlayer(@PathVariable("playerId") Long playerId, @RequestBody PlayerUpdateRequest request) {
        return playerService.updatePlayer(playerId, request);
    }
}
