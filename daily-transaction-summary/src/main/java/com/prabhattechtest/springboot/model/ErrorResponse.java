package com.prabhattechtest.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    private ErrorResponse() {
        setTimestamp(LocalDateTime.now());
    }

    public ErrorResponse(HttpStatus status) {
        this();
        this.setStatus(status);
    }

    public ErrorResponse(HttpStatus status, Throwable ex) {
        this();
        this.setStatus(status);
        this.setMessage("Unexpected error");
        this.setDebugMessage(ex.getLocalizedMessage());
    }

    public ErrorResponse(HttpStatus status, String message, Throwable ex) {
        this();
        this.setStatus(status);
        this.setMessage(message);
        this.setDebugMessage(ex.getLocalizedMessage());
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}
