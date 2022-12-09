package com.example.demo.rest;

import com.example.demo.bean.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/comment")
public class CommentRest {
    @Autowired
    CommentService commentService;


    @GetMapping("/id/{id}")
    public List<Comment> findByTaskId(@PathVariable String id) {
        return commentService.findByTaskId(id);
    }

    @PostMapping("/")
    public Comment save(@RequestBody Comment entity) {
        return commentService.save(entity);
    }
}
