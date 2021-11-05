package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap =new TreeMap<>();
    static {
        productMap.put(1,new Product(1,"MSI",
                1000,"Core i7, Ram 16GB","Gaming"));
        productMap.put(2,new Product(2,"Macbook Pro",
                2000,"M1 Pro Max, Ram 16GB","Apple"));
        productMap.put(3,new Product(3,"HP",
                500,"Core i5, Ram 8GB","HP-Office"));
        productMap.put(4,new Product(4,"Dell",
                600,"Core i5, Ram 8GB","Dell-Office"));
    }

    @Override
    public List<Product> showAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public boolean addNewProduct(Product product){
        productMap.put(product.getId(),product);
        return true;
    }

    @Override
    public void delete(int key) {
        productMap.remove(key);
    }

}
