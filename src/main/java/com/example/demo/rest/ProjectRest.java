package com.example.demo.rest;

import com.example.demo.bean.Project;
import com.example.demo.bean.User;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectRest {
    @Autowired
    ProjectService projectService;

    public Project findByUserId(String id) {
        return projectService.findByUserId(id);
    }

    @PostMapping("/")
    public Project save(@RequestBody Project p) {
        System.out.println("user : "+ p.getUser());
        return projectService.save(p);
    }
}
