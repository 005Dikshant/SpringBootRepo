package com.dikshant.user.service.exceptions;

import com.dikshant.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {

        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder()
                                          .message(message)
                                          .success(true)
                                          .status(HttpStatus.NOT_FOUND)
                                          .build();

        return new ResponseEntity<>(response,
                                    HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<ApiResponse> handleUnknownHostException(UnknownHostException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder()
                                          .message(message)
                                          .success(false)
                                          .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                          .build();

        return new ResponseEntity<>(response,
                                    HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
