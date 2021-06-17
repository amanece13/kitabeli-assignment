package com.kitabeli.application.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ProductNotFoundException extends RuntimeException{

    private Long timestamp;
    private HttpStatus status;
    private String message;
    private Boolean success;

    protected ProductNotFoundException() {}

    public ProductNotFoundException(
            Long timestamp, HttpStatus status, String message, Boolean success) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.success = success;
    }
}
