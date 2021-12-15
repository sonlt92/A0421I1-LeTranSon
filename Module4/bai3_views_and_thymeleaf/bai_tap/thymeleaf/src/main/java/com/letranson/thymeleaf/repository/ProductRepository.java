package com.letranson.thymeleaf.repository;

import com.letranson.thymeleaf.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

     Product finById(int id);

    void save(Product product);

//    void update(int id , Product product);
//
//    void remove(int id);
}
