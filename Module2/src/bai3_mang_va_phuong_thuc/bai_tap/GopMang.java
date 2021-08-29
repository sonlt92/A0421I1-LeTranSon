package bai3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeArr1;
        int sizeArr2;

        //Khoi tao mang thu 1 va nhap gia tri
        do {
            System.out.print("Enter a size array 1: ");
            sizeArr1 = input.nextInt();
            if (sizeArr1 > 20) {
                System.out.print("Size should not exceed 20");
            }
        } while (sizeArr1 > 20);
        int[] arr1 = new int[sizeArr1];
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter element " + i + " : ");
            arr1[i] = input.nextInt();
        }

        //Hien thi mang 1
        System.out.print("Property list array 1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }


        //Khoi tao mang thu 2 va nhap gia tri
        do {
            System.out.print("\nEnter a size array 2: ");
            sizeArr2 = input.nextInt();
            if (sizeArr2 > 20) {
                System.out.print("Size should not exceed 20");
            }
        } while (sizeArr2 > 20);
        int[] arr2 = new int[sizeArr2];
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Enter element " + i + " : ");
            arr2[i] = input.nextInt();
        }

        //Hien thi mang 2
        System.out.print("Property list array 2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "\t");
        }

        //Khai bao bien length = do dai 2 mang + lai
        int length = arr1.length + arr2.length;

        //Khoi tao mang moi de luu gia tri 2 mang
        int[] result = new int[length];
        int position = 0;

        //Dung vong lap de luu mang 1
        for (int element : arr1 ){
            result[position] = element;
            position++;
        }

        //Dung vong lap de luu mang 2
        for (int element : arr2 ){
            result[position] = element;
            position++;
        }

        //Hien thi ket qua
        System.out.println("\nThe new array after merging is: " + Arrays.toString(result));
    }
}
