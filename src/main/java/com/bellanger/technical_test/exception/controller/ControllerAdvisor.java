package com.bellanger.technical_test.exception.controller;

import com.bellanger.technical_test.dto.response.ErrorResponse;
import com.bellanger.technical_test.exception.object.EntityAlreadyExistException;
import com.bellanger.technical_test.exception.object.EntityNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleEntityAlreadyExistException(EntityAlreadyExistException e, WebRequest request) {
        ErrorResponse error = new ErrorResponse(e.getMessage(), new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EntityNotExistException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotExistException(EntityNotExistException e, WebRequest request) {
        ErrorResponse error = new ErrorResponse(e.getMessage(), new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
