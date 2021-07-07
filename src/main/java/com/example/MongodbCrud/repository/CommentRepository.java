package com.example.MongodbCrud.repository;

import com.example.MongodbCrud.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
