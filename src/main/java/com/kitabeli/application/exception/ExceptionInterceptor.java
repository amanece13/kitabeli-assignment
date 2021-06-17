package com.kitabeli.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public final ResponseEntity<Object> handleInvalidInputFormatException (InvalidInputException ex) {
        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getTimestamp(), ex.getStatus(), ex.getMessage(),false);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataFormatException.class)
    public final ResponseEntity<Object> handleDataFormatException (DataFormatException ex) {
        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getTimestamp(), ex.getStatus(), ex.getMessage(),false);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<Object> handleProductNotFoundException (ProductNotFoundException ex) {
        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(
                        ex.getTimestamp(), ex.getStatus(), ex.getMessage(),false);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
