package Bai3_Mang_Va_Phuong_Thuc.Bai_Tap;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Tao chuot
        String inputString;
        char characters;
        int count = 0;

        //Nhap chuoi
        System.out.println("Input string: ");
        inputString = input.nextLine();

        System.out.println("Input characters to count: ");
        characters = input.next().charAt(0);


        // Duyet chuoi va tra ve gia tri can dem
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == characters) {
                count++;
            }
        }

        System.out.println("Number of occurrences of the character " + characters + " in string " + inputString + " = " + count);
    }
}
