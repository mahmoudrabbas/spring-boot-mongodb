package com.example.store.bookshop.errors;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
