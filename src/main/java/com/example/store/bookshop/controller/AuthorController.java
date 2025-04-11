package com.example.store.bookshop.controller;


import com.example.store.bookshop.document.Author;
import com.example.store.bookshop.errors.CustomErrorResponse;
import com.example.store.bookshop.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(authorService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return ResponseEntity.ok(authorService.getById(id));
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(authorService.getByEmail(email));
    }
    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody @Valid Author entity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, String> errRes = new HashMap<>();
            CustomErrorResponse errorResponse = new CustomErrorResponse();
            bindingResult.getFieldErrors().forEach(err -> {
                    errorResponse
                            .localDateTime(LocalDateTime.now())
                            .details(err.getDefaultMessage())
                            .message(err.getDefaultMessage())
                            .statusCode(HttpStatus.BAD_REQUEST.toString())
                            .build();
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }else{
            return ResponseEntity.ok(authorService.insert(entity));
        }
    }
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Author entity){
        return ResponseEntity.ok(authorService.insert(entity));
    }

    @PutMapping("/{email}")
    public ResponseEntity<?> updateNameByEmail(@PathVariable("email") String email, @RequestParam("name") String name){
        return ResponseEntity.ok(authorService.updateNameByEmail(email, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(authorService.delete(id));
    }

}
