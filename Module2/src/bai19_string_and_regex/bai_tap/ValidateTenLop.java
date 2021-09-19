package bai19_string_and_regex.bai_tap;

import java.util.Scanner;

public class ValidateTenLop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input class name: ");
        String className = input.nextLine();
        System.out.println(className.matches("[CAP][0-9]{4}[GHIKLM]"));
    }
}
