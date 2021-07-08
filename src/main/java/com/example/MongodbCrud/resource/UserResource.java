package com.example.MongodbCrud.resource;


import com.example.MongodbCrud.exception.RestrictedInfoException;
import com.example.MongodbCrud.model.User;
import com.example.MongodbCrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/Users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@RequestParam("id") String id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody @Valid User user) throws RestrictedInfoException {
        if(user.getName().equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
         }
         return userService.saveUser(user);
    }
    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping
    public void deleteUser(@RequestParam(name = "id") String id){
        userService.deleteUser(id);
    }

}
