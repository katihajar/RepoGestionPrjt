package com.example.demo.repository;

import com.example.demo.bean.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends MongoRepository<Project, String> {
    Project findByUserId(String id);
    Project findByNomProjet(String nom);
}
