package com.letranson.furama.service.impl;

import com.letranson.furama.bean.User;
import com.letranson.furama.repository.UserRepository;
import com.letranson.furama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean checkUserName(String userName) {
        return userRepository.existsUserByUserName(userName);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
