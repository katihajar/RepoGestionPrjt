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

    @PutMapping("/chef/")
    public Project changeStautChef(@RequestBody Project p) {
        return projectService.changeStautChef(p);
    }

    @PutMapping("/dir/")
    public Project changeStautDirect(@RequestBody Project p) {
        return projectService.changeStautDirect(p);
    }

    @GetMapping("/")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/serviveProject/{id}")
    public List<Project> findByServicesId(@PathVariable String id) {
        return projectService.findByServicesId(id);
    }
    @GetMapping("/project/{id}")
    public Project findProjectById(@PathVariable String id) {
        return projectService.findProjectById(id);
    }
    @GetMapping("/projectServives/{id}/{st}")
    public List<Project> findByServicesIdAndStatutChef(@PathVariable String id,@PathVariable String st) {
        return projectService.findByServicesIdAndStatutChef(id, st);
    }
}
