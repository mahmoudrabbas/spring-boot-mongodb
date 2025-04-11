package com.example.store.bookshop.service;

import com.example.store.bookshop.document.Author;
import com.example.store.bookshop.errors.BusinessException;
import com.example.store.bookshop.errors.DocumentNotFound;
import com.example.store.bookshop.repository.AuthorRepo;
import com.example.store.bookshop.repository.CustomAuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private CustomAuthorRepo customAuthorRepo;


    // find all
    public List<Author> getAll(){
        return authorRepo.findAll();
    }

    // find by id
    public Author getById(String id){
        return authorRepo.findById(id).orElseThrow(() -> new DocumentNotFound("Author Not Found With ID: "+id));
    }

    // find by email
    public Author getByEmail(String email){
        return authorRepo.findByEmail(email);
    }


    // insert
    public Author insert(Author doc){
        if(getByEmail(doc.getEmail()) != null) throw new BusinessException("Email is Already in use");
        return authorRepo.insert(doc);
    }

    // update
    public Author update(Author doc){
        Author author = getById(doc.getId());
        author.setAuthorName(doc.getAuthorName());
        author.setEmail(doc.getEmail());

        return authorRepo.save(author);
    }

    // updated authorName by email
    public Long updateNameByEmail(String email, String name){
        return customAuthorRepo.updateNameByEmail(email, name);
    }


    // delete
    public int delete(String id){
        Author author = getById(id);
        authorRepo.delete(author);
        return 1;
    }



}
