package com.example.MongodbCrud.resource;

import com.example.MongodbCrud.model.Album;
import com.example.MongodbCrud.model.Photo;
import com.example.MongodbCrud.service.AlbumService;
import com.example.MongodbCrud.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {


    @Autowired
    private PhotoService photoService;

    @GetMapping
    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
    }

    @GetMapping("/{id}")
    public Optional<Photo> getPhotoById(@PathVariable(name = "id") String id){
        return photoService.getPhotoById(id);
    }

    @PostMapping
    public Photo savePhoto(@RequestBody Photo photo){
        return photoService.savePhoto(photo);
    }
    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){
        return photoService.updatePhoto(photo);
    }
    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "id") String id){
        photoService.deletePhoto(id);
    }
}
