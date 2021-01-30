package com.imona.api.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActionCreateRequest {
    private String name;
    private String description;
    private Long point;
}
