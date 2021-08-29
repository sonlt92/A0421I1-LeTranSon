package bai3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
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


        //Nhap vi tri phan tu can xoa
        int temp, j;
        System.out.println("\nEnter the element to be deleted: ");
        int delElement = scanner.nextInt();
        for (temp = j = 0; j < array.length; j++) {
            if (array[j] != delElement) {
                array[temp] = array[j];
                temp++;
            }
        }
        size = temp;
        System.out.print("Property list: ");
        for (j = 0; j < size; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
