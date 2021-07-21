package bai2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThiSoNguyenTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of primes to display: ");
        int number = input.nextInt();
        int count = 0;
        int n = 2;
        while (count < number) {
            if (isPrimeNumber(n)) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }

    public static boolean isPrimeNumber(int n)  {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

