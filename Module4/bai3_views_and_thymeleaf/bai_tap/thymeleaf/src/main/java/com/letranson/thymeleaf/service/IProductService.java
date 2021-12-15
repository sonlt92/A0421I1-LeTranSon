package com.letranson.thymeleaf.service;

import com.letranson.thymeleaf.model.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<Product> findAll();

    Product finById(int id);

    void save(Product product);
}
