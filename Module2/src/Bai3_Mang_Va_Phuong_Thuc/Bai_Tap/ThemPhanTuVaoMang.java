package Bai3_Mang_Va_Phuong_Thuc.Bai_Tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Khoi tao mang va nhap so phan tu vao mang
        int size;
        do {
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.print("Size should not exceed 20");
            }
        } while (size > 20);

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + " : ");
            arr[i] = scanner.nextInt();
        }

        //Hien thi mang
        System.out.print("Property list: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        //Nhap so can chen va vi tri can chen
        System.out.print("\nEnter the element to insert: ");
        int inputElement = scanner.nextInt();
        System.out.print("Enter the location to insert: ");
        int location = scanner.nextInt();
        int [] arrNew = ThemPhanTuVaoMang.insert(arr, inputElement, location);
        ThemPhanTuVaoMang.show(arrNew);

    }


    public static int[] insert(int[] arr, int input, int location) {
        int arrIndex = arr.length - 1;
        int tempIndex = arr.length;
        int[] tempArr = new int[tempIndex + 1];
        boolean inserted = false;

        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1 && arr[arrIndex] > location) {
                tempArr[i] = arr[arrIndex--];
            } else {
                if (!inserted) {
                    tempArr[i] = input;
                    inserted = true;
                } else {
                    tempArr[i] = arr[arrIndex--];
                }
            }
        }
        return tempArr;
    }

    public static void show (int [] arr){
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}