package com.example.demo.service;

import com.example.demo.bean.Comment;
import com.example.demo.bean.Task;
import com.example.demo.bean.User;
import com.example.demo.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserService userService;
    @Autowired
    TaskSercice taskSercice;

    public List<Comment> findByTaskId(String id) {
        return commentRepo.findByTaskId(id);
    }

    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    public Comment  save(Comment entity) {
         User us = userService.findById(entity.getUser().getId());
         Task ts= taskSercice.findTaskById(entity.getTask().getId());
         entity.setUser(us);
         entity.setTask(ts);
        return commentRepo.save(entity);
    }
}
