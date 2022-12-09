package com.example.demo.service;

import com.example.demo.bean.Project;
import com.example.demo.bean.Task;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskSercice {
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    ProjectRepo projectRepo;

    public List<Task> findByProjectId(String id) {
        return taskRepo.findByProjectId(id);
    }

    public Task findTaskById(String id) {
        return taskRepo.findTaskById(id);
    }

    public List<Task> saveAll(Project project, List<Task> tasks) {
        List<Task> taskList = new ArrayList<>();
        for (Task task : tasks) {
            Task task2 ;
            task.setProject(project);
            task.setStatutChef("en attente");
            task.setStatutDirect("en attente");
            task2= taskRepo.save(task);
            taskList.add(task2);
        }
        return taskList;
    }

    public Task findByProjectIdAndNom(String id, String nom) {
        return taskRepo.findByProjectIdAndNom(id, nom);
    }

    public Task save(Task task){
        Task t = findByProjectIdAndNom(task.getProject().getId(),task.getNom());
        if(t !=null){
            System.out.println("exist");
            return null;
        } else {
            Project p = projectRepo.findProjectById(task.getProject().getId());
            task.setProject(p);
            task.setStatutChef("en attente");
            task.setStatutDirect("en attente");
            System.out.println("t2 "+task);
            return taskRepo.save(task);
        }
    }

    public Task update(Task task){
        Task t = findTaskById(task.getId());
        t.setPourcentage(task.getPourcentage());
        return taskRepo.save(t);
    }

    public Task ValidateDirect(Task tt){
        Task ts1 = findTaskById(tt.getId());
        ts1.setStatutDirect(tt.getStatutDirect());
        return taskRepo.save(ts1);
    }


    public Task ValidateChef(Task t){
        Task ts2 = findTaskById(t.getId());
        ts2.setStatutChef(t.getStatutChef());
        return taskRepo.save(ts2);
    }
}
