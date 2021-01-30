package com.game.imona.model.response;


import com.game.imona.model.dto.ActionDto;
import com.game.imona.model.dto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private String logo;
    private List<PlayerDto> players;
    private List<ActionDto> actions;
}
