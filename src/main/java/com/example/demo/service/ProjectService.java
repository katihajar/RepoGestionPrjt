package com.example.demo.service;

import com.example.demo.bean.Project;
import com.example.demo.bean.Services;
import com.example.demo.bean.User;
import com.example.demo.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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


    public Project save( String us, String nom,String desc,double cout) {
        User user = userService.findById(us);
        Project p = new Project();
        p.setNomProjet(nom);
        p.setUser(user);
        p.setCout(cout);
        p.setDescription(desc);
        return projectRepo.save(p);

    }


}
