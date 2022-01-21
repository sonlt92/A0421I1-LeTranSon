package com.letranson.furama.service.impl;

import com.letranson.furama.bean.Division;
import com.letranson.furama.repository.DivisionRepository;
import com.letranson.furama.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }
}