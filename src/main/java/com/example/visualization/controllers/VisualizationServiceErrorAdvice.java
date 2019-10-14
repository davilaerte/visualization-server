package com.example.visualization.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.visualization.exceptions.CompilationErrorException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@ControllerAdvice
public class VisualizationServiceErrorAdvice {
	
    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }
    
    @ExceptionHandler({CompilationErrorException.class})
    public ResponseEntity<String> handleCompilationErrorException(CompilationErrorException e) {
        return error(NOT_ACCEPTABLE, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        return ResponseEntity.status(status).body(e.getMessage());
    }
}