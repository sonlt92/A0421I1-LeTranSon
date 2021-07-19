package Bai3_Mang_Va_Phuong_Thuc.Thuc_Hanh;

import java.util.Scanner;

public class DemSoLuongSinhVienThiDo {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if (size > 30){
                System.out.println("Size should not exceed 30");
            }
        }while (size >30);

        array = new int[size];
        int i = 0;
        while (i<array.length){
            System.out.println("Enter for student");
        }
    }
}
