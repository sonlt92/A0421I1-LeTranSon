package bai3_mang_va_phuong_thuc.bai_tap.bai_tap_them;

import java.util.Scanner;

public class Bai1 {
    //1.	Viết chương trình thực hiện các công việc như sau :
    //a.	Nhập một mảng a gồm n phần tử kiểu nguyên int
    //b.	Tính tổng số dương lẻ của mảng a
    //c.	Nhập vào phần tử k, tìm xem k có xuất hiện trong mảng a không. Nếu có chỉ ra các vị trí của k trong mảng.
    //d.	Sắp sếp mảng a theo thứ tự tăng dần.
    //e.	Chèn một số p vào mảng a sao cho mảng a vẫn đảm bảo tăng dần.
    public static void main(String[] args) {
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

        System.out.print("\nSum Odd: " + SumOdd(arr));

    }

    public static int SumOdd(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                sum += arr[i];
            }
        }
        return sum;
    }

}
