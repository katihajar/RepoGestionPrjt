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
        System.out.println("hna all"  +tasks);
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
            System.out.println(" first t1 "+task.getProject().getId());
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
        t.setDateDebut(task.getDateDebut());
        t.setDateFin(task.getDateFin());
        t.setNom(task.getNom());
        t.setPourcentage(task.getPourcentage());
        t.setTaskDescription(task.getTaskDescription());
        return taskRepo.save(t);
    }

    public Task ValidateDirect(String id,String st){
        Task ts1 = findTaskById(id);
        ts1.setStatutDirect(st);
        return taskRepo.save(ts1);
    }


    public Task ValidateChef(String id,String st){
        Task ts2 = findTaskById(id);
        ts2.setStatutChef(st);
        return taskRepo.save(ts2);
    }
}
