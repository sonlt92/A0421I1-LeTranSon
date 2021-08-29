package bai3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class TongDuongCheoMang2Chieu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Khai bao dong,cot mang 2 chieu
        int row, col;
        System.out.print("Input row of Array: ");
        row = input.nextInt();
        System.out.print("Input column of Array: ");
        col = input.nextInt();

        //Khai bao mang 2 chieu
        int[][] Arr = new int[row][col];

        System.out.print("Input the element of Array: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("\nArr[" + i + "][" + j + "] = ");
                Arr[i][j] = input.nextInt();
            }
        }

        //Hien thi mang 2 chieu
        System.out.println("Array:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(Arr[i][j] + "\t");
            }
            System.out.println("\n");
        }

        //Ting tong duong cheo
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // kiểm tra nếu i == j thì mới tính tổng
                if (i == j) {
                    sum += Arr[i][j];
                }
            }
        }
        System.out.print("The sum of elements lying on the diagonal: " + sum);
    }

}
