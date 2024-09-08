package com.example.chess.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        log.error("服务端异常: {} >> {}", e.getClass(), e.getMessage());
        return ResponseEntity.status(500).body("服务端异常: " + e.getMessage());
    }
}
