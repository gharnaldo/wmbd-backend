package com.wmbd.backendmain.exceptions;

import com.wmbd.backendmain.enumerator.ErrorCodeEnumerator;

public class CustomException extends RuntimeException {
	
	private ErrorCodeEnumerator code;
	
    public CustomException(String message) {
        super(message);
        this.code = ErrorCodeEnumerator.DEFAULT;
    }

    public CustomException(ErrorCodeEnumerator errorCodeEnumerator) {
        super("");
        this.code = errorCodeEnumerator;
    }

    public CustomException(String message, ErrorCodeEnumerator errorCodeEnumerator) {
        super(message);
        this.code = errorCodeEnumerator;
    }

    public ErrorCodeEnumerator getCode() {
        return code;
    }

    public void setCode(ErrorCodeEnumerator code) {
        this.code = code;
    } 
}
