package model.repository;

import model.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    List<Product> selectAll();

    boolean insert(Product product);

    boolean update(Product product);

    boolean delete(int id);

    Product findById(int id);

    Product findByName(String name);
}
