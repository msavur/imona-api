package com.game.imona.model.response;


import com.imona.core.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerBaseResponse {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private Date birthDate;
    private boolean flag;
    private Long cityId;
}
