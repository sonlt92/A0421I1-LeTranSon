package com.letranson.furama.service;

import com.letranson.furama.bean.CustomerType;

public interface TypeOfCustomerService {
    Iterable<CustomerType> findAll();
}