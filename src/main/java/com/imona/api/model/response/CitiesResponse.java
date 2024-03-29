package com.imona.api.model.response;


import com.imona.api.model.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitiesResponse {
    private List<BaseDto> cities;
}
