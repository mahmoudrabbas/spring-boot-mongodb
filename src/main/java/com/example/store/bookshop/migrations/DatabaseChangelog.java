package com.example.store.bookshop.migrations;

import com.example.store.bookshop.model.Author;
import com.example.store.bookshop.repository.AuthorRepo;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

@ChangeLog(order = "001")
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "seedAuthors", author = "mahmoud")
    public void seedAuthors(AuthorRepo AuthorRepo) {
        Author author1 = new Author("Mahmoud R Abbas", "mra@gmail.com", "software developer");
        Author author2 = new Author("Mostafa Moamer", "mmh@gmail.com", "Accountant");
        AuthorRepo.save(author1);
        AuthorRepo.save(author2);
    }
}
