package bai3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class TongCacSoOMotCot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Khai bao so dong va cot cua mang 2 chieu
        int row, col;
        System.out.print("Input row of Array: ");
        row = scanner.nextInt();
        System.out.print("Input column of Array: ");
        col = scanner.nextInt();

        //Khai bao mang 2 chieu
        int[][] Arr = new int[row][col];

        System.out.print("Input the element of Array: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("\nArr[" + i + "][" + j + "] = ");
                Arr[i][j] = scanner.nextInt();
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

        int elementCol;
        int sumCol = 0;
        System.out.print("Enter column to calculate the total: ");
        elementCol = scanner.nextInt();
        for (int i = 0; i < row; i++) {
            for (int j = elementCol; j < col; j++) {
                if (j == elementCol){
                sumCol += Arr[i][j];
               }
            }
        }
        System.out.println("Sum column " + elementCol + " is: " + sumCol);
    }


}
