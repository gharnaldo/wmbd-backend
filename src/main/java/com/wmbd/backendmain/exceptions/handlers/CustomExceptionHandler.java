package com.wmbd.backendmain.exceptions.handlers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wmbd.backendmain.exceptions.ExceptionResponse;
import com.wmbd.backendmain.exceptions.ExceptionWithMessage;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ExceptionWithMessage.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequest(ExceptionWithMessage ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false), ex.getStatus().getReasonPhrase());
        return new ResponseEntity<>(exceptionResponse, ex.getStatus());
    }


}
