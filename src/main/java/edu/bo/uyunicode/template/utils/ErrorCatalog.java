package edu.bo.uyunicode.template.utils;

public enum ErrorCatalog {
    USER_NOT_FOUND("USR_001", "Usuario no encontrado"),
    USER_INVALID("USR_002", "Usuario invalido"),
    GENERIC_ERROR("ERR_001", "Un error inesperado ocurrió");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
