package com.letranson.thymeleaf.service;


import com.letranson.thymeleaf.model.Product;
import com.letranson.thymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product finById(int id) {
        return productRepository.finById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

}
