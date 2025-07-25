package com.hack.hack25.controller;

import com.hack.hack25.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(CommonException.class)
    ResponseEntity<String> commonException(CommonException e){
        return ResponseEntity.status(422).body(e.getMessage());
    }
}
