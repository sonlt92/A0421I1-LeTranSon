package model.bean;

public class Product {
    private int id;
    private String name;
    private int price;
    private String productDescription;
    private String manufacturer;

    public Product() {
    }

    public Product(int id, String name, int price, String productDescription, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productDescription = productDescription;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
