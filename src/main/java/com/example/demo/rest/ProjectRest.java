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

    @PostMapping("/add/{us}/{nom}/{description}/{cout}")
    public Project save(@PathVariable("us") String us, @PathVariable("nom") String nom,@PathVariable("description") String desc, @PathVariable("cout") double cout) {
        return projectService.save(us,nom,desc,cout);
    }
}
