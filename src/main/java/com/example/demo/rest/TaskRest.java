package com.example.demo.rest;

import com.example.demo.bean.Task;
import com.example.demo.service.TaskSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/task")
public class TaskRest {
    @Autowired
    TaskSercice taskSercice;
    @GetMapping("/ProjectId/{id}")
    public List<Task> findByProjectId(@PathVariable String id) {
        return taskSercice.findByProjectId(id);
    }

    @GetMapping("/id/{id}")
    public Task findTaskById(@PathVariable String id) {
        return taskSercice.findTaskById(id);
    }

    @PostMapping("/")
    public Task save(@RequestBody Task task) {
        return taskSercice.save(task);
    }

    @PutMapping("/hna")
    public Task update(@RequestBody Task task) {
        return taskSercice.update(task);
    }
    @PutMapping("/valdDir/")
    public Task ValidateDirect(@RequestBody Task t) {
        return taskSercice.ValidateDirect(t);
    }
    @PutMapping("/valdChef/")
    public Task ValidateChef(@RequestBody Task t) {
        return taskSercice.ValidateChef(t);
    }
}
