package com.letranson.thymeleaf.repository;


import com.letranson.thymeleaf.model.Product;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "S21", new String[]{"SamSung"}));
        products.add(new Product(2, "XS Max", new String[]{"iPhone"}));
        products.add(new Product(3, "XZ1", new String[]{"Sony"}));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product finById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
