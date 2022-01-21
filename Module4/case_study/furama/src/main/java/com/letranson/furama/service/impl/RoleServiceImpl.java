package com.letranson.furama.service.impl;

import com.letranson.furama.bean.Role;
import com.letranson.furama.repository.RoleRepository;
import com.letranson.furama.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }
}
