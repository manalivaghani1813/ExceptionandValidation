package com.example.MongodbCrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity<String> restrictedInfoError(RestrictedInfoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

   /* @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> NoSuchUserError(){
        return new ResponseEntity<>("User doesn't exist", HttpStatus.CONFLICT);
    }*/
}
