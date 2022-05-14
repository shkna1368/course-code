package com.mapsa.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(value = NotFoundExcpetion.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundExcpetion excpetion){
         Map<String,Object> res=new HashMap<>();

         res.put("message",excpetion.getMessage());

         return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<?> handleConflictException(ConflictException excpetion){
         Map<String,Object> res=new HashMap<>();

         res.put("message",excpetion.getMessage());

         return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }
}
