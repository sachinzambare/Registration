package com.api.exception;

import com.api.payload.EroorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<EroorDto> resourceNotFound(ResourceNotFoundException r,
WebRequest request
    ){
EroorDto error= new EroorDto(r.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<EroorDto> handleGlobalException(
            Exception e,WebRequest request
    ){
        EroorDto error= new EroorDto(e.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
