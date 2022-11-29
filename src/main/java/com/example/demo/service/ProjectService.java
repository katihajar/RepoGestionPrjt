package com.example.demo.service;

import com.example.demo.bean.Project;
import com.example.demo.bean.Services;
import com.example.demo.bean.User;
import com.example.demo.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    UserService userService;

    public Project findByUserId(String id) {
        return projectRepo.findByUserId(id);
    }

    public Project findByNomProjet(String nom) {
        return projectRepo.findByNomProjet(nom);
    }

    public Project findProjectById(String id) {
        return projectRepo.findProjectById(id);
    }

    public Project save(Project p) {
        Project pr = findByNomProjet(p.getNomProjet());
        if(pr !=null) {
            System.out.println("exist");
            return null;
        } else {
            p.setStatutChef(false);
            p.setStatutDirect(false);
            return projectRepo.save(p);
        }
    }

    @Transactional
    public int deleteListProjectById(List<Project> projectsList) {
        int res = 0;
        for (int i = 0; i < projectsList.size(); i++) {
            res += deleteProjectByid(projectsList.get(i).getId());
        }
        return res;
    }

    @Transactional
    public int deleteProjectByid(String id) {
        int deleteByid = projectRepo.deleteProjectByid(id);
        return deleteByid;
    }

    public Project changeStautChef(String id,Boolean st) {
        Project pro =findProjectById(id);
        pro.setStatutChef(st);
        return projectRepo.save(pro);
    }
    public Project changeStautDirect(String id,Boolean stDir) {
        Project pro =findProjectById(id);
        pro.setStatutDirect(stDir);
        return projectRepo.save(pro);
    }
}
