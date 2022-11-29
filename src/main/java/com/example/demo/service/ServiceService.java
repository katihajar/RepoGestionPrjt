package com.example.demo.service;

import com.example.demo.bean.Services;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;




    public List<Services> findAll() {
        return serviceRepository.findAll();
    }

    public Services findByNomService(String domaine) {
        return serviceRepository.findByNomService(domaine);
    }

    @Transactional
    public int deleteServiceById(String id) {
        return serviceRepository.deleteServiceById(id);
    }
    @Transactional
    public int deleteListServiceById(List<Services> servicesList) {
        int res = 0;
        for (int i = 0; i < servicesList.size(); i++) {
            res += deleteServiceById(servicesList.get(i).getId());
        }
        return res;
    }

    public Services save(Services services) {
        Services them = findByNomService(services.getNomService());
        if(them==null) {
            return serviceRepository.save(services);
        }else{
            return null;
        }
    }



}
