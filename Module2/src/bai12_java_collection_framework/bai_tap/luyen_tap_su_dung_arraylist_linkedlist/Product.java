package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;


import java.util.List;

public class Product implements Comparable<Product>{
    private int id;
    private int price;
    private String name;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Product name: " + this.name + ", ID: " + this.id + ", Price: " + this.price;
    }


    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
