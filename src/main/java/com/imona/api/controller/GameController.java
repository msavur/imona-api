package com.imona.api.controller;


import com.imona.api.controller.endpoint.GameEndPoint;
import com.imona.api.model.request.FormCreateRequest;
import com.imona.api.model.response.GameResponse;
import com.imona.api.service.GameService;
import com.imona.core.generic.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "http://localhost:3000")
public class GameController {

    private final GameService gameService;

    @GetMapping(value = GameEndPoint.GET_GAME)
    public GenericResponse<GameResponse> getGame(@PathVariable("gameId") Long gameId) {
        return gameService.getGame(gameId);
    }

    @PostMapping(value = GameEndPoint.CREATE_GAME)
    public GenericResponse create(@RequestBody FormCreateRequest request) {
        return gameService.create(request);
    }
}
