package com.example.MongodbCrud.repository;

import com.example.MongodbCrud.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album,String> {

}
