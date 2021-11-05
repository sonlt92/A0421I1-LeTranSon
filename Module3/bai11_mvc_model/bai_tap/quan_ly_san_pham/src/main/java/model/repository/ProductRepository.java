package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> showAll();
    boolean addNewProduct(Product product);
    void delete (int key);
}
