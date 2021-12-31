package com.codegym.gio_hang.bean;

import org.springframework.stereotype.Component;

@Component
public class Cart {
    private Integer id;

    private Product product;

    private int quantity;

    public Cart() {
    }

    public Cart(Integer id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
