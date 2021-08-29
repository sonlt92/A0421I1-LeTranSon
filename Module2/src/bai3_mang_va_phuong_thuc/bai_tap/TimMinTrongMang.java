package bai3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class TimMinTrongMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        //Khoi tao mang
        do {
            System.out.print("Enter a size array: ");
            size = input.nextInt();
            if (size > 20) {
                System.out.print("Size should not exceed 20");
            }
        } while (size > 20);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + " : ");
            arr[i] = input.nextInt();
        }

        //Hien thi mang 1
        System.out.print("Property list array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        //Tim min
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        System.out.print("\nElement min in Array is: " + min);
    }
}
