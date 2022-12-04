package com.example.demo.repository;

import com.example.demo.bean.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepo extends MongoRepository<Role, String> {

    Role findByName(String name);
}
