package com.wmbd.backendmain.transportLayer;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.wmbd.backendmain.exceptions.ExceptionWithMessage;


public class ErrorResponse {



    public static ExceptionWithMessage handleRequestException (Exception  e){

        HttpStatus status;

        if (e instanceof HttpClientErrorException) {
            status = ((HttpClientErrorException) e).getStatusCode();
            return new ExceptionWithMessage(((HttpClientErrorException) e).getResponseBodyAsString(), status);
        }
        if (e instanceof HttpServerErrorException) {
            status = ((HttpClientErrorException) e).getStatusCode();
            return new ExceptionWithMessage(((HttpServerErrorException) e).getResponseBodyAsString(), status);
        }
        if (e instanceof IllegalArgumentException) {
            return new ExceptionWithMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
        }else{
        return new ExceptionWithMessage(((HttpServerErrorException) e).getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
        }
    }
}



