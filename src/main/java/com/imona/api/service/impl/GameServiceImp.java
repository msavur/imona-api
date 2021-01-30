package com.imona.api.service.impl;

import com.imona.api.model.dto.PlayerDto;
import com.imona.api.model.request.FormCreateRequest;
import com.imona.api.model.response.GameResponse;
import com.imona.api.repository.ActionRepository;
import com.imona.api.repository.GameRepository;
import com.imona.api.repository.PlayerRepository;
import com.imona.api.service.GameService;
import com.imona.core.entity.Action;
import com.imona.core.entity.Game;
import com.imona.core.entity.Player;
import com.imona.core.generic.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImp implements GameService {

    private final GameRepository gameRepository;
    private final ActionRepository actionRepository;
    private final PlayerRepository playerRepository;

    @Override
    public GenericResponse<GameResponse> getGame(Long movieId) {
        Optional<Game> gameOptional = gameRepository.findById(movieId);
        if (!gameOptional.isPresent()) {
            return GenericResponse.resourceNotFound();
        }
        Game game = gameOptional.get();
        GameResponse response = new GameResponse();
        converterGameResponse(game, response);
        return GenericResponse.ok(response);
    }

    @Transactional
    @Override
    public GenericResponse<?> create(FormCreateRequest request) {
        Optional<Player> playerOptional = playerRepository.findById(request.getPlayer().getPlayerId());

        if (!playerOptional.isPresent()) {
            throw new ResourceNotFoundException("The player you entered is not available in the system.!");
        }

        Player player = playerOptional.get();
        Game game = setGameAttribute(request);
        Game savedGame = gameRepository.save(game);
        player.setGame(game);
        playerRepository.save(player);
        Action action = setActionAttribute(request, player, savedGame);
        actionRepository.save(action);
        return GenericResponse.ok();
    }

    private Game setGameAttribute(FormCreateRequest request) {
        Game game = new Game();
        game.setName(request.getGame().getName());
        game.setDescription(request.getGame().getDescription());
        game.setEnabled(true);
        game.setCreatedDate(new Date());
        return game;
    }

    private Action setActionAttribute(FormCreateRequest request, Player player, Game savedGame) {
        Action action = new Action();
        action.setName(request.getAction().getName());
        action.setDescription(request.getAction().getDescription());
        action.setPoint(request.getAction().getPoint());
        action.setCreatedDate(new Date());
        action.setEnabled(true);
        action.setGame(savedGame);
        return action;
    }

    private void converterGameResponse(Game game, GameResponse response) {
        response.setDescription(game.getDescription());
        response.setId(game.getId());
        response.setName(game.getName());
        response.setLogo(game.getLogo());
        List<PlayerDto> players = game.getPlayers().stream()
                .map(player -> new PlayerDto(player.getId(), player.getName(), player.getSurname(), player.getGender())).collect(Collectors.toList());
        response.setPlayers(players);
    }
}
