package com.letranson.furama.service.impl;

import com.letranson.furama.bean.EducationDegree;
import com.letranson.furama.repository.EducationDegreeRepository;
import com.letranson.furama.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
