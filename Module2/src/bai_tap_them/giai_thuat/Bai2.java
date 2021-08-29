package bai_tap_them.giai_thuat;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input month: ");
        int months = input.nextInt();
        switch (months){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print("Date is: 31");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("Date is: 30");
                break;
            case 2:
                System.out.print("Date is: 28 or 29");
                break;
            default:
                System.out.println("The month does not exist. Please re-enter.");
                break;
        }
    }
}
