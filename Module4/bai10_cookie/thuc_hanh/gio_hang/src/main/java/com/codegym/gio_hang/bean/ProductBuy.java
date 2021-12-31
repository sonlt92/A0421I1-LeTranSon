package com.codegym.gio_hang.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductBuy {
    @Id
    private Integer id;

    private String nameProduct;

    private Integer quantity;

    private Integer total;

    public ProductBuy() {
    }

    public ProductBuy(Integer id, String nameProduct, Integer quantity, Integer total) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
