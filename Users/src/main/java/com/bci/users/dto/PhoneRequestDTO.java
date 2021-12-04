package com.bci.users.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PhoneRequestDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String number;
    private String citycode;
    private String countrycode;
}
