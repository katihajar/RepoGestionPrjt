package com.example.demo.rest;

import com.example.demo.bean.Role;
import com.example.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/role")
public class RoleREST {

    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/allRoles")
    public List<Role> findAllRoles (){
        return roleRepo.findAll();
    }

    @GetMapping("/name/{name}")
    public Role findByName(@PathVariable String name) {
        return roleRepo.findByName(name);
    }
}
