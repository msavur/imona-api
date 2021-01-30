package com.game.imona.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FormCreateRequest {
    private GameCreateRequest game;
    private PlayerBaseCreateRequest player;
    private ActionCreateRequest action;
}
