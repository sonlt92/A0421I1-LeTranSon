package com.letranson.furama.service.impl;

import com.letranson.furama.bean.RentType;
import com.letranson.furama.repository.RentTypeRepository;
import com.letranson.furama.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}