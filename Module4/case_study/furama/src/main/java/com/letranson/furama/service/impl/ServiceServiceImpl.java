package com.letranson.furama.service.impl;

import com.letranson.furama.bean.Service;
import com.letranson.furama.repository.ServiceRepository;
import com.letranson.furama.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> findByName(Pageable pageable, String name) {
        return serviceRepository.findByServiceNameLike(pageable, name);
    }

    @Override
    public Iterable<Service> findAllNotPage() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.delete(service);
    }
}
