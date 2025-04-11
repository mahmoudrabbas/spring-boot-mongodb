package com.example.store.bookshop.repository;

import org.springframework.stereotype.Component;

public interface CustomAuthorRepo {
    Long updateNameByEmail(String email, String authorName);
}
