package case_study.controllers;

import java.util.Scanner;

public class FuramaController {

    public static void displayMainMenu() {

        boolean choice = true;
        while (choice) {
            System.out.print("\n============MENU===========");
            System.out.print("\n1.Employee Management");
            System.out.print("\n2.Customer Management");
            System.out.print("\n3.Facility Management");
            System.out.print("\n4.Booking Managerment");
            System.out.print("\n5.Promotion Management");
            System.out.print("\n6.Exit");
            System.out.print("\n===========================");
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter your choice: ");

            switch (input.nextInt()) {
                case 1: {
                    displayEmployeeManagement();
                    break;
                }
                case 2: {

                }
            }
        }
    }

    public static void displayEmployeeManagement() {

        boolean choice = true;
        while (choice) {
            System.out.print("1.Display list employees");
            System.out.print("\n2.Add new employee");
            System.out.print("\n3.Edit employee");
            System.out.print("\n4.Return main menu");
            Scanner input = new Scanner(System.in);

            switch (input.nextInt()) {
                case 1: {

                }
            }
        }
    }
}
