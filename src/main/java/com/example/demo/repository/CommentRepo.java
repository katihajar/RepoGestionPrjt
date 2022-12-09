package com.example.demo.repository;

import com.example.demo.bean.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepo extends MongoRepository<Comment, String> {
    List<Comment> findByTaskId(String id);

}
