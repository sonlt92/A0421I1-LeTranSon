package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAll();

    boolean insert(Product product);

    boolean update(Product product);

    boolean delete(int id);

    Product findById(int id);

    Product findByName(String name);
}
