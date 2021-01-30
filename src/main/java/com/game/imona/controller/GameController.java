package com.game.imona.controller;


import com.game.imona.controller.endpoint.GameEndPoint;
import com.game.imona.model.request.FormCreateRequest;
import com.game.imona.model.response.GameResponse;
import com.game.imona.service.GameService;
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
