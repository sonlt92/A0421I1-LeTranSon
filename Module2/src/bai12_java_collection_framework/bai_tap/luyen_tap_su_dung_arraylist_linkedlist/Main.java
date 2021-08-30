package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1);
        product.setName("ZorinOS");
        product.setPrice(40);

        Product product1 = new Product();
        product1.setId(2);
        product1.setName("Ubuntu");
        product1.setPrice(0);

        ProductManager productManager = new ProductManager();
        productManager.addProduct(product);
        productManager.addProduct(product1);
        productManager.displayProduct(1);
    }
}
