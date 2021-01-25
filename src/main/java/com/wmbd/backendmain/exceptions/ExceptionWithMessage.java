package com.wmbd.backendmain.exceptions;


import org.springframework.http.HttpStatus;

public class ExceptionWithMessage extends RuntimeException {

    private HttpStatus status;

    public ExceptionWithMessage(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
