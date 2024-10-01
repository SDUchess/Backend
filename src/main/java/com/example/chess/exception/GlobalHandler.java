package com.example.chess.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RestControllerAdvice
public class GlobalHandler {
    private static final Pattern DUPLICATE_PATTERN = Pattern.compile("\\[Duplicate entry '(?<value>.+)' for key '(?<field>.+)']");

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException e){
        String message = e.getMessage();
        log.error("数据完整性异常: >> {}", message);
        Matcher matcher = DUPLICATE_PATTERN.matcher(message);
        if (matcher.find()) {
            String value = matcher.group("value");
            // String field = matcher.group("field");
            return ResponseEntity.status(400).body(value + " 与已有的数据重复");
        }
        return ResponseEntity.status(400).body("数据完整性异常: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        log.error("服务端异常: {} >> {}", e.getClass(), e.getMessage());
        return ResponseEntity.status(500).body("服务端异常: " + e.getMessage());
    }
}
