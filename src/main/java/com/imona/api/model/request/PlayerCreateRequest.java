package com.imona.api.model.request;

import com.imona.core.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PlayerCreateRequest {
    private String name;
    private String surname;
    private Gender gender;
    private Date birthDate;
    private boolean flag;
    private Long city;
}
