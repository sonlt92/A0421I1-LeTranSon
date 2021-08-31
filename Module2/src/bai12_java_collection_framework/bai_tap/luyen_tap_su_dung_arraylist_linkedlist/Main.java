package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1);
        product.setName("ZorinOS");
        product.setPrice(40);

        Product product1 = new Product();
        product1.setId(2);
        product1.setName("Ubuntu");
        product1.setPrice(100);

        Product product2 = new Product();
        product2.setId(3);
        product2.setName("Deepin");
        product2.setPrice(10);

        ProductManager productManager = new ProductManager();
        productManager.addProduct(product);
        productManager.addProduct(product1);
        productManager.addProduct(product2);
        productManager.displayProduct(0);
        productManager.displayProduct(1);
        productManager.displayProduct(2);
        CompareTest compareTest = new CompareTest();
//        Collections.sort(productManager,compareTest);
    }
}
