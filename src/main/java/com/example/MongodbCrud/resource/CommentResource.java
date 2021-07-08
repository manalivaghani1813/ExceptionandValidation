package com.example.MongodbCrud.resource;

import com.example.MongodbCrud.model.Comment;
import com.example.MongodbCrud.model.Photo;
import com.example.MongodbCrud.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Optional<Comment> getCommentById(@PathVariable(name = "id") String id){
        return commentService.getCommentById(id);
    }

    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment){
        return commentService.saveComment(comment);
    }
    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }
    @DeleteMapping
    public void deleteComment(@RequestParam(name = "id") String id){
        commentService.deleteComment(id);
    }
}
