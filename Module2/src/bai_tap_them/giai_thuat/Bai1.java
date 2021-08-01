package bai_tap_them.giai_thuat;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input height: ");
        int height = input.nextInt();
        for (int i=0; i<height;i++){
            System.out.print("\n");
            for (int j=0;j<height;j++){
                System.out.print("*");
            }
        }
    }
}
