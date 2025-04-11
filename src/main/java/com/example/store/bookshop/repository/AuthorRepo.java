package com.example.store.bookshop.repository;

import com.example.store.bookshop.document.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends MongoRepository<Author, String> {

    @Query(value = "{email:'?0'}", fields = "{'authorName':1}")
    Author findByEmail(String email);
}
