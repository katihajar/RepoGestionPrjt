package com.example.demo.rest;

import com.example.demo.bean.Task;
import com.example.demo.service.TaskSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskRest {
    @Autowired
    TaskSercice taskSercice;

    @GetMapping("/id/{id}")
    public Task findTaskById(@PathVariable String id) {
        return taskSercice.findTaskById(id);
    }

    @PostMapping("/")
    public Task save(@RequestBody Task task) {
        return taskSercice.save(task);
    }

    @PutMapping("/")
    public Task update(@RequestBody Task task) {
        return taskSercice.update(task);
    }
    @PutMapping("/valdDir/{id}/{st}")
    public Task ValidateDirect(@PathVariable String id,@PathVariable  String st) {
        return taskSercice.ValidateDirect(id, st);
    }
    @PutMapping("/valdChef/{id}/{st}")
    public Task ValidateChef(@PathVariable String id,@PathVariable  String st) {
        return taskSercice.ValidateChef(id, st);
    }
}
