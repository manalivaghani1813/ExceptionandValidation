package com.example.MongodbCrud.service;

import com.example.MongodbCrud.model.Photo;
import com.example.MongodbCrud.repository.PhotoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepositoy photoRepositoy;

    public List<Photo> getAllPhotos() {
        return photoRepositoy.findAll();
    }

    public Optional<Photo> getPhotoById(String id) {
        return photoRepositoy.findById(id);
    }

    public Photo savePhoto(Photo photo) {
        return photoRepositoy.save(photo);
    }

    public Photo updatePhoto(Photo photo) {
        return photoRepositoy.save(photo);
    }

    public void deletePhoto(String id) {
         photoRepositoy.deleteById(id);
    }
}
