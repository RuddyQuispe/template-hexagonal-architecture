package edu.bo.uyunicode.template.infrastructure.adapter.input.rest;

import edu.bo.uyunicode.template.domain.exception.UserNotFoundException;
import edu.bo.uyunicode.template.domain.model.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;

import static edu.bo.uyunicode.template.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(USER_NOT_FOUND.getCode(),
                        USER_NOT_FOUND.getMessage(),
                        LocalDateTime.now(),
                        null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(USER_INVALID.getCode(),
                        USER_INVALID.getMessage(),
                        LocalDateTime.now(),
                        result.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(GENERIC_ERROR.getCode(),
                        GENERIC_ERROR.getMessage(),
                        LocalDateTime.now(),
                        Collections.singletonList(e.getMessage())));
    }
}
