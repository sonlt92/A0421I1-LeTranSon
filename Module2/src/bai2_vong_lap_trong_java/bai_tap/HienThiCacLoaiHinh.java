package bai2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    System.out.println("Input length: ");
                    int length = input.nextInt();
                    System.out.println("Input width: ");
                    int width = input.nextInt();
                    for (int i = 1; i <= width; i++) {
                        for (int j = 1; j <= length; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle");
                    System.out.println("Input height: ");
                    int height = input.nextInt();
                    for (int i = 1; i <= height; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    for (int i = height; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    for (int i = 1; i <= height; i++) {
                        /* Print spaces in decreasing order of row */
                        for (int j = i; j < height; j++) {
                            System.out.print(" ");
                        }

                        /* Print star in increasing order or row */
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }

                        /* Move to next line */
                        System.out.println();
                    }
                    for (int i = 1; i <= height; i++) {
                        /* Print leading spaces */
                        for (int j = 1; j < i; j++) {
                            System.out.print(" ");
                        }

                        /* Iterate through columns to print star */
                        for (int j = i; j <= height; j++) {
                            System.out.print("*");
                        }

                        /* Move to next line */
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Print isosceles triangle");
                    System.out.println("Input height: ");
                    int heights = input.nextInt();
                    for (int i = 1; i <= heights; i++) {
                        for (int j = 1; j <= heights - i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
