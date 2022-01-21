package com.letranson.furama.service.impl;

import com.letranson.furama.bean.ServiceType;
import com.letranson.furama.repository.ServiceTypeRepository;
import com.letranson.furama.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}