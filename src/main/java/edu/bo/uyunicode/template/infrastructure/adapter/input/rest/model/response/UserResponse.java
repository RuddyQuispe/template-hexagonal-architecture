package edu.bo.uyunicode.template.infrastructure.adapter.input.rest.model.response;

import java.io.Serializable;

public record UserResponse(
        Long id,
        String username,
        String nickname,
        Boolean isEnabled) implements Serializable {
}
