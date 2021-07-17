package Bai3_Mang_Va_Phuong_Thuc.Bai_Tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {

        //Khoi tao mang va nhap so phan tu vao mang
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.print("Size should not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }

        //Hien thi mang
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        //Nhap so can chen va vi tri can chen

        System.out.print("\nEnter the element to insert: ");
        int inputElement = scanner.nextInt();
        System.out.print("Enter the location to insert: ");
        int location = scanner.nextInt();
        // Neu so luong phan tu lon hon hoac bang suc chua cua mang thi khong the them
        if (i >= size) {
            System.out.println("Error");
        }
        // vi tri them phan tu phai thuoc khoang[0, i]
        if (location < 0 || location > i) {
            for (int j = i; j > location; j--) {
                array[j] = array[j - 1];
            }
            array[location] = inputElement;
            System.out.println("Test: " + array[i + 1]);
        }
    }
}




