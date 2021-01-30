package com.game.imona.model.response;


import com.game.imona.model.dto.ActionDto;
import com.game.imona.model.dto.BaseDto;
import com.game.imona.model.dto.GameDto;
import com.imona.core.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponse {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private Date birthDate;
    private boolean flag;
    private BaseDto city;
    private GameDto game;
    private List<ActionDto> actions;
}
