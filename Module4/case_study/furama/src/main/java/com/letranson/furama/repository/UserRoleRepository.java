package com.letranson.furama.repository;

import com.letranson.furama.bean.Role;
import com.letranson.furama.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findByUsers(User user);
}
