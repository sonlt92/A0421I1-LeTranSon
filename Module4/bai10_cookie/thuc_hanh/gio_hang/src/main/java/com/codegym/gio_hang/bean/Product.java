package com.codegym.gio_hang.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Integer id;

    private String nameProduct;
    private String linkImg;
    private Integer price;

    public Product() {
    }

    public Product(Integer id, String nameProduct, String linkImg, Integer price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.linkImg = linkImg;
        this.price = price;
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

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
