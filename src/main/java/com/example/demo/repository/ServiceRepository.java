package com.example.demo.repository;

import com.example.demo.bean.Services;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<Services, String> {
   Services findByNomService(String domaine);
    int deleteServiceById(String id);
}
