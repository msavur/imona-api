package com.game.imona.service.impl;

import com.game.imona.model.dto.BaseDto;
import com.game.imona.model.dto.GameDto;
import com.game.imona.model.request.PlayerCreateRequest;
import com.game.imona.model.request.PlayerUpdateRequest;
import com.game.imona.model.response.PlayerBaseResponse;
import com.game.imona.model.response.PlayerResponse;
import com.game.imona.model.response.PlayersResponse;
import com.game.imona.repository.PlayerRepository;
import com.game.imona.service.PlayerService;
import com.imona.core.entity.City;
import com.imona.core.entity.Player;
import com.imona.core.generic.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImp implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public GenericResponse<PlayerResponse> getPlayer(Long playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (!playerOptional.isPresent()) {
            return GenericResponse.resourceNotFound();
        }
        Player player = playerOptional.get();
        PlayerResponse response = new PlayerResponse();
        converterPlayerResponse(player, response);
        return GenericResponse.ok(response);
    }

    @Override
    public GenericResponse<PlayersResponse> getAllPlayers() {
        List<Player> players = playerRepository.findAllByEnabledTrue();
        if (CollectionUtils.isEmpty(players)) {
            return GenericResponse.resourceNotFound();
        }
        List<PlayerBaseResponse> responses = preparedPlayerBaseResponse(players);
        return GenericResponse.ok(new PlayersResponse(responses));
    }


    @Transactional
    @Override
    public GenericResponse deletePlayer(Long playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (!playerOptional.isPresent()) {
            return GenericResponse.resourceNotFound();
        }
        Player player = playerOptional.get();
        player.setEnabled(false);
        playerRepository.save(player);
        return GenericResponse.ok();
    }

    @Transactional
    @Override
    public GenericResponse createPlayer(PlayerCreateRequest request) {
        Player player = new Player();
        player.setEnabled(true);
        player.setCreatedDate(new Date());
        player.setName(request.getName());
        player.setSurname(request.getSurname());
        player.setGender(request.getGender());
        player.setFlag(request.isFlag());
        player.setBirthDate(request.getBirthDate());
        City city = new City();
        city.setId(request.getCity());
        player.setCity(city);
        playerRepository.save(player);
        return GenericResponse.ok();
    }

    @Override
    public GenericResponse updatePlayer(Long playerId, PlayerUpdateRequest request) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (!playerOptional.isPresent()) {
            return GenericResponse.resourceNotFound();
        }
        Player player = playerOptional.get();
        setPlayerAttribute(request, player);
        playerRepository.save(player);
        return GenericResponse.ok();
    }

    private void setPlayerAttribute(PlayerUpdateRequest request, Player player) {
        player.setName(request.getName());
        player.setSurname(request.getSurname());
        player.setGender(request.getGender());
        player.setFlag(request.isFlag());
        player.setBirthDate(request.getBirthDate());
        City city = new City();
        city.setId(request.getCity());
        player.setCity(city);
    }

    private void converterPlayerResponse(Player player, PlayerResponse response) {
        response.setBirthDate(player.getBirthDate());
        response.setFlag(player.isFlag());
        response.setId(player.getId());
        response.setGender(player.getGender());
        response.setSurname(player.getSurname());
        response.setName(player.getName());
        response.setCity(new BaseDto(player.getCity().getId(), player.getCity().getName()));
        response.setGame(new GameDto(player.getGame().getId(), player.getGame().getName(), player.getGame().getDescription(), player.getGame().getLogo()));
    }

    private List<PlayerBaseResponse> preparedPlayerBaseResponse(List<Player> players) {
        return players.stream()
                .map(player -> new PlayerBaseResponse(
                        player.getId(),
                        player.getName(),
                        player.getSurname(),
                        player.getGender(),
                        player.getBirthDate(),
                        player.isFlag(),
                        player.getCity().getId()))
                .collect(Collectors.toList());
    }
}
