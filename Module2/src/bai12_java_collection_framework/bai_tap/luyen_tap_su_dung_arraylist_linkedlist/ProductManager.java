package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;

import java.util.ArrayList;

public class ProductManager {
    public static ArrayList<Product> products = new ArrayList<Product>();


    public void addProduct(Product name) {
        products.add(name);
    }

    public void removeProduct(int id) {
        products.remove(products.get(id));
    }

    public void displayProduct(int id) {
        System.out.println(products.get(id).toString());
    }

    public void searchProduct(String name) {
        boolean check = true;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(name)) {
                System.out.println("Found products in location: " + i);
                check = false;
            }
        }
        if (check) {
            System.out.println("No products found");
        }
    }

//    public void sortProduct(){
//        Collections.sort(products);
//    }

}
