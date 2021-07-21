package bai3_mang_va_phuong_thuc.bai_tap.bai_tap_them;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InputArray();
    }

    public static int InputArray() {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size array: ");
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

        //Hien thi mang
        System.out.print("Property list: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        return InputArray();
    }
}
