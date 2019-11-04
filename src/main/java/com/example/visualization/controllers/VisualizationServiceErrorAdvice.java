package com.example.visualization.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.visualization.exceptions.CompilationImplErrorException;
import com.example.visualization.exceptions.RunImplErrorException;
import com.example.visualization.exceptions.TimeoutRunMethodException;
import com.example.visualization.models.errors.ErrorType;
import com.example.visualization.models.errors.ImplError;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class VisualizationServiceErrorAdvice {
	
    @ExceptionHandler({RunImplErrorException.class})
    public ResponseEntity<ImplError> handleException(RunImplErrorException e) {
    	Throwable cause = e.getCause();
    	StackTraceElement firstStackTrace = cause.getStackTrace()[0];
    	ImplError runError = new ImplError(ErrorType.RUN, cause.toString(), null, firstStackTrace);
    	return error(INTERNAL_SERVER_ERROR, runError);
    }
    
    @ExceptionHandler({CompilationImplErrorException.class})
    public ResponseEntity<ImplError> handleCompilationErrorException(CompilationImplErrorException e) {
        ImplError compilationError = new ImplError(ErrorType.COMPILATION, e.getMessage(), null, null);
    	return error(INTERNAL_SERVER_ERROR, compilationError);
    }
    
    @ExceptionHandler({TimeoutRunMethodException.class})
    public ResponseEntity<ImplError> handleTimeoutRunMethodException(TimeoutRunMethodException e) {
        ImplError runTimeoutError = new ImplError(ErrorType.RUN, e.getMessage(), e.getMethod(), null);
    	return error(INTERNAL_SERVER_ERROR, runTimeoutError);
    }


    private ResponseEntity<ImplError> error(HttpStatus status, ImplError error) {
        return ResponseEntity.status(status).body(error);
    }
}