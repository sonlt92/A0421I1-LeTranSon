package com.letranson.furama.repository;

import com.letranson.furama.bean.Employee;
import com.letranson.furama.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee findByUser(User user);

    Page<Employee> findByNameLike(Pageable pageable,String name);
}
