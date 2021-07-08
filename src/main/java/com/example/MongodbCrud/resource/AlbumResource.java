package com.example.MongodbCrud.resource;

import com.example.MongodbCrud.model.Album;
import com.example.MongodbCrud.model.User;
import com.example.MongodbCrud.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public Optional<Album> getAlbumById(@PathVariable(name = "id") String id){
        return albumService.getAlbumeById(id);
    }

    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album){
        return albumService.saveAlbum(album);
    }
    @PutMapping
    public Album updateAlbum(@RequestBody Album album){
        return albumService.updateAlbum(album);
    }
    @DeleteMapping
    public void deleteAlbum(@RequestParam(name = "id") String id){
        albumService.deleteAlbum(id);
    }
}
