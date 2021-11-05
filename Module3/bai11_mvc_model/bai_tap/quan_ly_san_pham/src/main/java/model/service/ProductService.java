package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> showAll();
    boolean addNewProduct(Product product);
    void delete(int key);
}
