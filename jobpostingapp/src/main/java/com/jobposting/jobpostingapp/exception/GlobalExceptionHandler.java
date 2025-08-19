package com.jobposting.jobpostingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Handel exception for 500
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handelRunTimeException(RuntimeException runtimeException) {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("error", "Internal server error");
        error.put("message", runtimeException.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //handel exception 400 bad request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handelValidationError(MethodArgumentNotValidException exception) {
     Map<String, Object> error = new HashMap<>();
     error.put("timeStamp", LocalDateTime.now());
     error.put("status", HttpStatus.BAD_REQUEST.value());
     error.put("error", "Bad request");
     error.put("message", exception.getMessage());
     return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //404 Not found
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<CustomErrorResponse> handelResourceNotFoundException(NoHandlerFoundException resourceNotFoundException) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setTimeStamp(LocalDateTime.now());
        error.setMessage(resourceNotFoundException.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //catch All other exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handelUnhandledException(Exception eexception) {
        Map<String, Object> error = new HashMap<>();
        error.put("timeStamp", LocalDateTime.now());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("error", "Unexpected error");
        error.put("message", eexception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
