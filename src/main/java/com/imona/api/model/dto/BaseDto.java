package com.imona.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseDto implements Serializable {
    private Long id;
    private String name;

    public BaseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
