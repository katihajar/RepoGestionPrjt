package com.example.demo.rest;

import com.example.demo.bean.Services;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/service")
public class ServicesRest {
    @Autowired
    ServiceService serviceService;

    @GetMapping("/all")
    public List<Services> findAll() {
        return serviceService.findAll();
    }
    @GetMapping("/domaine/{domaine}")
    public Services findByDomaine(@PathVariable String domaine) {
        return serviceService.findByNomService(domaine);
    }

    @DeleteMapping("/id/{id}")
    public int deleteServiceById(@PathVariable String id) {
        return serviceService.deleteServiceById(id);
    }

    @DeleteMapping("/DleteMulty-id")
    public int deleteListServiceById(@RequestBody List<Services> servicesList) {
        return serviceService.deleteListServiceById(servicesList);
    }

    @PostMapping("/")
    public Services save(@RequestBody Services entity) {
        System.out.println(entity);
        return serviceService.save(entity);
    }
}
