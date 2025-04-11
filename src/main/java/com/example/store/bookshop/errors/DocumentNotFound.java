package com.example.store.bookshop.errors;

public class DocumentNotFound extends RuntimeException{
    public DocumentNotFound(String message) {
        super(message);
    }
}
