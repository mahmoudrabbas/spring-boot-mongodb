package com.example.store.bookshop.errors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DocumentNotFound.class)
    public ResponseEntity<?> handleDocumentNotFound(DocumentNotFound ex){
        CustomErrorResponse err = new CustomErrorResponse();
                    err
                        .localDateTime(LocalDateTime.now())
                        .details(ex.getMessage())
                        .message(ex.getMessage())
                        .statusCode(String.valueOf(HttpStatus.NOT_FOUND))
                        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleDuplicateEmail(BusinessException ex){
        CustomErrorResponse response = new CustomErrorResponse();
                    response
                            .localDateTime(LocalDateTime.now())
                            .details(ex.getMessage())
                            .message(ex.getMessage())
                            .statusCode(String.valueOf(HttpStatus.BAD_REQUEST))
                            .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
