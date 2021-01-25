package com.wmbd.backendmain.exceptions;

import java.util.Date;

public class ExceptionResponse{

    private Date timestamp;

    private String message;

    private String path;

    private String code;

    public ExceptionResponse(Date timestamp, String message, String path, String code) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
