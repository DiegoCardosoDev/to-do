package com.diego.todo.resources.exeptions;


import com.diego.todo.services.exeptions.ObjectNotFoudExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExeptionHandler {

    @ExceptionHandler(ObjectNotFoudExeption.class)

    public ResponseEntity<StandardError> objNotFound (ObjectNotFoudExeption exeption, ServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(), exeption.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);


    }
}
