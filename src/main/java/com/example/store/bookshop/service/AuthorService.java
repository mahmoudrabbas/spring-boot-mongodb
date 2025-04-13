package com.example.store.bookshop.service;

import com.example.store.bookshop.model.Author;
import com.example.store.bookshop.errors.BusinessException;
import com.example.store.bookshop.errors.DocumentNotFound;
import com.example.store.bookshop.repository.AuthorRepo;
import com.example.store.bookshop.repository.CustomAuthorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private CustomAuthorRepo customAuthorRepo;

    @Autowired
    private MessageSource messageSource;

    Logger log = LoggerFactory.getLogger(Author.class);


    // find all
    public List<Author> getAll(){
        return authorRepo.findAll();
    }

    // find by id
    public Author getById(String id){
        String [] params = {id};
        String msg =messageSource.getMessage("error.message.notFoundDocument", params, LocaleContextHolder.getLocale());
        return authorRepo.findById(id).orElseThrow(() -> new DocumentNotFound(msg));
    }

    // find by email
    public Author getByEmail(String email){
        Author author = authorRepo.findByEmail(email);
        log.info("Name is {} and Email is{}", author.getAuthorName(), author.getEmail() );
        return author;
    }


    // insert
    public Author insert(Author doc){
        if(getByEmail(doc.getEmail()) != null) throw new BusinessException("Email is Already in use");
        Author saved = authorRepo.insert(doc);
        logAuthorDetailsAsync(saved);
        return saved;
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


    @Async
    public void logAuthorDetailsAsync(Author author) {
        System.out.println("Logging author in thread: " + Thread.currentThread().getName());
        System.out.println("Author: " + author.getAuthorName() + ", Email: " + author.getEmail());

        // consider we are sending an email here so it would take tine
        try {
            Thread.sleep(3000);
            System.out.println("Done logging for: " + author.getAuthorName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
