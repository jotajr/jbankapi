package com.jotajr.jbankapi.exception.advice;

import com.jotajr.jbankapi.exception.AgenciaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AgenciaNotFoundExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(AgenciaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String agenciaExceptionHandler(AgenciaNotFoundException ex) {
        return ex.getMessage();
    }
}
