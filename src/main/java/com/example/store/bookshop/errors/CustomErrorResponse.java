package com.example.store.bookshop.errors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomErrorResponse {
    private String statusCode;
    private String message;
    private LocalDateTime localDateTime;
    private List<String> details = new ArrayList<>();

    public CustomErrorResponse localDateTime(LocalDateTime localDateTime){
        this.localDateTime = localDateTime;
        return this;
    }
    public CustomErrorResponse message(String message){
        this.message = message;
        return this;
    }
    public CustomErrorResponse statusCode(String statusCode){
        this.statusCode = statusCode;
        return this;
    }

    public CustomErrorResponse details(String detail){
        this.details.add(detail);
        return this;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public CustomErrorResponse build(){
        return this;
    }
}
