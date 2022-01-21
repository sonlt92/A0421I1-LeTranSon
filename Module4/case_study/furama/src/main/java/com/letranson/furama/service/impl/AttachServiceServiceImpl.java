package com.letranson.furama.service.impl;

import com.letranson.furama.bean.AttachService;
import com.letranson.furama.repository.AttachServiceRepository;
import com.letranson.furama.service.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}