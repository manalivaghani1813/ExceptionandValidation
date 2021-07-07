package com.example.MongodbCrud.repository;

import com.example.MongodbCrud.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepositoy extends MongoRepository<Photo,String> {

}
