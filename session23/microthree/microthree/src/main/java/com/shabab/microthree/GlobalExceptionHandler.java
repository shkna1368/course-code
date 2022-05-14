package com.shabab.microthree;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(value = NotfoundException.class)
    public ResponseEntity<?> exception(NotfoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

     @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<?> exception(ConflictException exception) {

         Map<String, Object> response = new HashMap<>();


         response.put("message", exception.getMessage());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }



}
