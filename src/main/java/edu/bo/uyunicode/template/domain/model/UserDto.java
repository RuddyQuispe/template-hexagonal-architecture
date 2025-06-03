package edu.bo.uyunicode.template.domain.model;

public record UserDto(
        Long id,
        String username,
        String nickname,
        Boolean isEnabled) {
}
