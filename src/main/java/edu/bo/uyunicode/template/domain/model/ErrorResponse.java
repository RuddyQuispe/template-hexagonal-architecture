package edu.bo.uyunicode.template.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
        String code,
        String message,
        LocalDateTime date,
        List<String> detail) implements Serializable {
}
