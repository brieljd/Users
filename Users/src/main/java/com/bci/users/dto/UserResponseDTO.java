package com.bci.users.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponseDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dateOfCreation;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dateOfModified;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime lastLogin;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isActive;
}
