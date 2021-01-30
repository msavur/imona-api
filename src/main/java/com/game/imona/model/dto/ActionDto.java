package com.game.imona.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionDto extends BaseDto {

    private String description;
    private Long point;

    public ActionDto(Long id, String name, String description, Long point) {
        super(id, name);
        this.description = description;
        this.point = point;
    }
}
