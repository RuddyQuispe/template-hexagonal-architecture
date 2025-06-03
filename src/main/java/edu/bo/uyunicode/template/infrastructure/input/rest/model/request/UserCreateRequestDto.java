package edu.bo.uyunicode.template.infrastructure.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record UserCreateRequestDto(
        @NotBlank(message = "username requerido")
        String username,
        @NotBlank(message = "nickname requerido")
        String nickname,
//        @DefaultValue(Boolean.TRUE)
        Boolean isEnabled) implements Serializable {
}
