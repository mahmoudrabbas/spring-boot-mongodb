package com.example.store.bookshop.errors;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomError extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorResponse =  super.getErrorAttributes(webRequest, options);
        errorResponse.put("success", Boolean.FALSE);
        errorResponse.put("status", errorResponse.get("error"));
        errorResponse.put("exception", errorResponse.get("message"));
        errorResponse.remove("error");
        errorResponse.remove("path");
        return errorResponse;
    }
}
