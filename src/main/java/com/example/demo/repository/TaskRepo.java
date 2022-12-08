package com.example.demo.repository;


import com.example.demo.bean.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends MongoRepository<Task, String>{
    Task findTaskById(String id);
    Task findByProjectIdAndNom(String id, String nom);
    List<Task> findByProjectId(String id);

}
