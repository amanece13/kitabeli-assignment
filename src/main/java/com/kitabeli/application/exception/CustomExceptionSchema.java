package com.kitabeli.application.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomExceptionSchema {
    private Long timestamp;
    private HttpStatus status;
    private String message;
    private boolean success;

    protected CustomExceptionSchema() {}

    public CustomExceptionSchema(Long timestamp, HttpStatus status, String message, Boolean success
    ) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.success = success;
    }
}
