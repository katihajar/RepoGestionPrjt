package com.example.demo.repository;

import com.example.demo.bean.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends MongoRepository<Project, String> {
    List<Project> findByUserId(String id);
    Project findProjectById(String id);
    Project findByNomProjet(String nom);
    int deleteProjectByid(String id);
    List<Project> findByServicesId(String id);

}
