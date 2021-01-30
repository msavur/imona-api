package com.imona.api.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDto extends BaseDto {
    private String description;
    private String logo;

    public GameDto(Long id, String name, String description, String logo) {
        super(id, name);
        this.description = description;
        this.logo = logo;
    }
}
