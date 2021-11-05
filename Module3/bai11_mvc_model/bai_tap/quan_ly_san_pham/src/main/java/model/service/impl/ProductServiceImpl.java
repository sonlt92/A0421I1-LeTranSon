package model.service.impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> showAll() {
        return this.productRepository.showAll();
    }

    @Override
    public boolean addNewProduct(Product product){
        this.productRepository.addNewProduct(product);
        return true;
    }

    @Override
    public void delete(int key) {
        this.productRepository.delete(key);
    }
}
