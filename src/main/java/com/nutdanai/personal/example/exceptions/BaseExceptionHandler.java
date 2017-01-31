package com.nutdanai.personal.example.exceptions;

import com.nutdanai.personal.example.models.ErrorResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BaseExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({GreetingRequestException.class})
    protected
    @ResponseBody
    ErrorResource handleGreetingRequest(RuntimeException exception, WebRequest request) {
        GreetingRequestException greetException = (GreetingRequestException) exception;
        return new ErrorResource(404, greetException.getMessage());
    }

}
