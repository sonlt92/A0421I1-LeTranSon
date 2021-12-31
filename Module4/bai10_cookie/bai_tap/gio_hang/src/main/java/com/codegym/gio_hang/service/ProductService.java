package com.codegym.gio_hang.service;

import com.codegym.gio_hang.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void save(Product product);

    void delete(Product product);
}