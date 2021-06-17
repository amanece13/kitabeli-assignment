package com.kitabeli.application.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DataFormatException extends RuntimeException {
    private Long timestamp;
    private HttpStatus status;
    private String error;
    private String message;

    protected DataFormatException() {}

    public DataFormatException(
            Long timestamp, HttpStatus status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
