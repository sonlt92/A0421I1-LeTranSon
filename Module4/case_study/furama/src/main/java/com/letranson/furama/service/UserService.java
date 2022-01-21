package com.letranson.furama.service;

import com.letranson.furama.bean.User;

public interface UserService {
    Boolean checkUserName(String userName);

    User findById(String id);

    Iterable<User> findAll();

    void save(User user);
}