package bai1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input USD to VND: ");
        int usd = scanner.nextInt();
        int vnd = usd * rate;
        System.out.println(vnd + " VND");
    }
}
