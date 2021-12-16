package com.codegym.quan_ly_ds_khach_hang.model.service;

import com.codegym.quan_ly_ds_khach_hang.model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer finById(int id);

    void save(Customer customer);

    void edit(Customer customer);

    void delete(int id);

    List<Customer> search(String searchValue);
}