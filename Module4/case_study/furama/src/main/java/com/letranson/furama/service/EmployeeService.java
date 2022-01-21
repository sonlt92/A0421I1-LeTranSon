package com.letranson.furama.service;

import com.letranson.furama.bean.Employee;
import com.letranson.furama.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByName(Pageable pageable, String name);

    Employee findByUser(User user);

    Iterable<Employee> findAllNotPage();

    Employee findById(String id);

    void save(Employee employee);

    void delete(Employee employee);
}
