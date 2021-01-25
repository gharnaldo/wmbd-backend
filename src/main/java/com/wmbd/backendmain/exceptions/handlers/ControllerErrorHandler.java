package com.wmbd.backendmain.exceptions.handlers;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@Service
public class ControllerErrorHandler {

    public String handleError (Errors errors){

        String errorsInfo = "";
        for(int i = 0; i <=errors.getErrorCount(); i++){
            errorsInfo = ((FieldError) errors.getAllErrors().get(0)).getField() +
                    " "+ errors.getAllErrors().get(0).getDefaultMessage();
        }

        return errorsInfo;
    }

}
