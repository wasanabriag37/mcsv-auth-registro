package com.nuevaeps.auth.infrastruture.input.controllers_advices;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nuevaeps.auth.domain.exceptions.ExceptionAuthUser;

@RestControllerAdvice
public class LoginControllerAdvice {

    @ExceptionHandler(ExceptionAuthUser.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundAttachedException(ExceptionAuthUser ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
