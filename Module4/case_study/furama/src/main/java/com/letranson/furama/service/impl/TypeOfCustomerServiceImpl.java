package com.letranson.furama.service.impl;

import com.letranson.furama.bean.CustomerType;
import com.letranson.furama.repository.TypeOfCustomerRepository;
import com.letranson.furama.service.TypeOfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfCustomerServiceImpl implements TypeOfCustomerService {
    @Autowired
    private TypeOfCustomerRepository typeOfCustomerRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return typeOfCustomerRepository.findAll();
    }
}
