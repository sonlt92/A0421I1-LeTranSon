package com.letranson.furama.repository;

import com.letranson.furama.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsUserByUserName(String user);
}