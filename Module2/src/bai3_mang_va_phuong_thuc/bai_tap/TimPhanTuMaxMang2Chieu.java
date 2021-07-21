package bai3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class TimPhanTuMaxMang2Chieu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Khai bao so dong va cot cua mang 2 chieu
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

        //Tim phan tu max trong mang 2 chieu
        //VD Max = [0,0];
        int max = Arr[0][0];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < Arr[i][j]) {
                    max = Arr[i][j];
                }
            }
        }
        System.out.print("Element max in Array is: " + max);
    }
}
