package com.example.store.bookshop.document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authors")
public class Author {
    @Id
    private String id;
    
    @NotNull(message = "Name is Required")
    private String authorName;

    @NotBlank(message = "Job is Required")
    private String job;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private String createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private String LastModifiedDate;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    @Indexed(unique = true)
    private String email;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }
}
