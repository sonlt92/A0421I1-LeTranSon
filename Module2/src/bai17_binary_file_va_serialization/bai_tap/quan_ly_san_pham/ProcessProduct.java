package bai17_binary_file_va_serialization.bai_tap.quan_ly_san_pham;

import java.io.*;
import java.util.Scanner;

public class ProcessProduct {
    public Product[] create() {      // Input the data from Keyboard
        int n;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of Product: ");
        n = Integer.parseInt(scan.nextLine());  //nhap so luong

        Product[] Product = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter id:");
            int id = Integer.parseInt(scan.nextLine());
            System.out.print("Enter name: ");   // nhap ten
            String name = scan.nextLine();
            System.out.print("Enter brand: ");   // nhap hang
            String brand = scan.nextLine();
            System.out.print("Enter money: ");    // nhap tien
            double money = Double.parseDouble(scan.nextLine());    // tranh troi lenh nhu khi dung scan.nextDouble()
            System.out.print("Enter descriptions: ");   // nhap mo ta
            String desc = scan.nextLine();
            Product[i] = new Product(id, name, brand, money, desc);    // khoi tao doi tuong Product thu i
        }

        scan.close();
        return Product;
    }

    public void write(Product[] product) {  //ghi theo Object
        FileOutputStream f = null;
        ObjectOutputStream oStream = null;
        try {   // dat try cacth de tranh ngoai le khi tao va ghi File
            f = new FileOutputStream("E:\\STUDY\\A0421I1-LeTranSon\\Module2\\src\\bai17_binary_file_va_serialization\\bai_tap\\quan_ly_san_pham\\Product.txt");   // tao file f tro den Product.dat
            oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
            oStream.writeObject(product);   // ghi Product theo kieu Object vao file
        } catch (IOException e) {
            System.out.println("Error Write file");
        } finally {
            try {
                oStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Product[] read() {       // doc theo Object
        Product[] Product = null;
        ObjectInputStream inStream = null;
        FileInputStream f = null;
        try {   // dat try cacth de tranh ngoai le khi tao va doc File
            f = new FileInputStream("E:\\STUDY\\A0421I1-LeTranSon\\Module2\\src\\bai17_binary_file_va_serialization\\bai_tap\\quan_ly_san_pham\\Product.txt"); // tao file f tro den Product.dat
            inStream = new ObjectInputStream(f);  // dung de doc theo Object vao file f
            // dung inStream doc theo Object, ep kieu tra ve la Product
            Product = (Product[]) inStream.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        } finally {
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Product;
    }

    public void show(Product[] product) throws Exception {      //In data doc duoc tu file ra man hinh
        try {
            for (int i = 0; i < product.length; i++) {
                System.out.println((i + 1) + " :\n" +
                        "Product id is: " + product[i].getId() +
                        "\n Product name is: " + product[i].getName() +
                        "\n Product brand is: " + product[i].getBrand() +
                        "\n Product money is:" + product[i].getMoney() +
                        "\n Product desc is:" + product[i].getDescriptions());
            }
        } catch (NullPointerException e) {
            System.out.println("File Empty");
        }
    }
}
