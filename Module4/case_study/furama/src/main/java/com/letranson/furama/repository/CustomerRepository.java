package com.letranson.furama.repository;

import com.letranson.furama.bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Page<Customer> findByCustomerNameLike(Pageable pageable, String name);
}
