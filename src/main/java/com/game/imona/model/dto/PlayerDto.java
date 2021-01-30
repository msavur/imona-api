package com.game.imona.model.dto;

import com.imona.core.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto extends BaseDto {
    private String surname;
    private Gender gender;

    public PlayerDto(Long id, String name, String surname, Gender gender) {
        super(id, name);
        this.surname = surname;
        this.gender = gender;
    }
}
