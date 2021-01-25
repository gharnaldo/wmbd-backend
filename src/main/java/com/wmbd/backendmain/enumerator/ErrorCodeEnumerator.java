package com.wmbd.backendmain.enumerator;

public enum ErrorCodeEnumerator {
    DEFAULT(0, "Default Error"),
    RESOURCE_CONFLICT(1, "Resource already exists"),
    NO_CONTENT(2, "No data found"),
	BAD_REQUEST(3, "Bad request"), 
	NOT_FOUND(4, "Not Found");

    private final int code;
    private final String description;

    ErrorCodeEnumerator(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorCodeEnumerator{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}
