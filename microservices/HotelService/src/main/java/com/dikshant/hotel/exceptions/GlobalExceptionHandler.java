package com.dikshant.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException ex){
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("Status", HttpStatus.NOT_FOUND);
        map.put("success", false);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);

    }
}
