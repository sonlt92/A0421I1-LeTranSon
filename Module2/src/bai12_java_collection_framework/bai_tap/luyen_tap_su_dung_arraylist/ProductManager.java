package bai12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static Scanner imput = new Scanner(System.in);
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Apple",1000));
        productList.add(new Product(2,"Samsung",700));
        productList.add(new Product(3,"Xiaomi",500));
    }

    public static void displayMenu(){
        int choice = 0;
        while (true){
            System.out.println("Vui long chon: " +
                    "\n 1. Hien thi" +
                    "\n 2. Them moi" +
                    "\n 3. Xoa" +
                    "\n 4. Sua" +
                    "\n 5. Thoat");
            choice = imput.nextInt();
            imput.skip("\\R");
            switch (choice){
                case 1:
                    displayMenu();
                    break;
                case 2:
            }
        }
    }

}
