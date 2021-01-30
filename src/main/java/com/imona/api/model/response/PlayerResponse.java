package com.imona.api.model.response;


import com.imona.api.model.dto.ActionDto;
import com.imona.api.model.dto.BaseDto;
import com.imona.api.model.dto.GameDto;
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
