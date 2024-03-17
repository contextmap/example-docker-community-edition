package com.webshop.shoppingcart.configuration;

import com.webshop.shoppingcart.service.exceptions.EntityNotFound;
import com.webshop.shoppingcart.service.exceptions.EntityNotUnique;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<Object> handle(EntityNotFound ex, WebRequest request) {
        var body = createProblemDetail(ex, HttpStatus.BAD_REQUEST, ex.getMessage(), null, null, request);
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(EntityNotUnique.class)
    public ResponseEntity<Object> handle(EntityNotUnique ex, WebRequest request) {
        var body = createProblemDetail(ex, HttpStatus.BAD_REQUEST, ex.getMessage(), null, null, request);
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
