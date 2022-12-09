package com.example.demo.rest;

import com.example.demo.bean.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/project")
public class ProjectRest {
    @Autowired
    ProjectService projectService;
    @GetMapping("/userProject/{id}")
    public List<Project> findByUserId(@PathVariable String id) {
        return projectService.findByUserId(id);
    }

    @PostMapping("/")
    public Project save(@RequestBody Project p) {
        return projectService.save(p);
    }

    @PostMapping("/Multy")
    public int deleteListProjectById(@RequestBody List<Project> projectsList) {
        return projectService.deleteListProjectById(projectsList);
    }

    @DeleteMapping("/id/{id}")
    public int deleteProjectByid(@PathVariable String id) {
        return projectService.deleteProjectByid(id);
    }

    @PutMapping("/chef/{id}/{st}")
    public Project changeStautChef(@PathVariable String id,@PathVariable String st) {
        return projectService.changeStautChef(id, st);
    }

    @PutMapping("/dir/{id}/{stDir}")
    public Project changeStautDirect(@PathVariable String id,@PathVariable String stDir) {
        return projectService.changeStautDirect(id, stDir);
    }

    @GetMapping("/")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/serviveProject/{id}")
    public List<Project> findByServicesId(@PathVariable String id) {
        return projectService.findByServicesId(id);
    }


}
