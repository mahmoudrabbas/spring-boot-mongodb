package com.example.store.bookshop.repository;

import com.example.store.bookshop.model.Author;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthorRepoImpl implements CustomAuthorRepo{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Long updateNameByEmail(String email, String authorName) {
        Query query = new Query(Criteria.where("email").is(email));

        Update update = new Update();
        update.set("authorName", authorName);

        UpdateResult res = mongoTemplate.updateFirst(query,  update, Author.class);

        if(res == null)
            return 0L;
        else
            return res.getModifiedCount();
    }
}
