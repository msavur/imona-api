package com.game.imona.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameCreateRequest {
    private String name;
    private String description;
    private String logo;
}
