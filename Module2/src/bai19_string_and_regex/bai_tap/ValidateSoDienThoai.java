package bai19_string_and_regex.bai_tap;

import java.util.Scanner;

public class ValidateSoDienThoai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input phone number:");
        String phoneNumber = input.nextLine();
        System.out.println(phoneNumber.matches("[(][\\d]{2}[)][(]0[\\d]{9}[)]"));
    }
}
