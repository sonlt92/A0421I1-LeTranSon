package case_study.controllers;

import case_study.services.impl.EmployeeServiceImpl;

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
                    displayCustomerManagement();
                    break;
                }
                case 3: {
                    displayFacilityManagement();
                    break;
                }
                case 4: {
                    displayBookingManagerment();
                    break;
                }
                case 5: {
                    displayPromotionManagement();
                    break;
                }
                case 6:
                    System.exit(6);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static void displayEmployeeManagement() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean choice = true;
        while (choice) {
            System.out.print("1.Display list employees");
            System.out.print("\n2.Add new employee");
            System.out.print("\n3.Edit employee");
            System.out.print("\n4.Return main menu");
            System.out.print("\n5.Exit");
            System.out.print("\n===========================");
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter your choice: ");
            switch (input.nextInt()) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 5:
                    System.exit(5);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static void displayCustomerManagement() {

        boolean choice = true;
        while (choice) {
            System.out.print("1.Display list customers");
            System.out.print("\n2.Add new customer");
            System.out.print("\n3.Edit customer");
            System.out.print("\n4.Return main menu");
            System.out.print("\n5.Exit");
            System.out.print("\n===========================");
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter your choice: ");

            switch (input.nextInt()) {
                case 5:
                    System.exit(5);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static void displayFacilityManagement() {

        boolean choice = true;
        while (choice) {
            System.out.print("1.Display list facility");
            System.out.print("\n2.Add new facility");
            System.out.print("\n3.Edit facility maintenance");
            System.out.print("\n4.Return main menu");
            System.out.print("\n5.Exit");
            System.out.print("\n===========================");
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter your choice: ");

            switch (input.nextInt()) {
                case 5:
                    System.exit(5);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static void displayBookingManagerment() {

        boolean choice = true;
        while (choice) {
            System.out.print("1.Add new booking");
            System.out.print("\n2.Display list booking");
            System.out.print("\n3.Create new constracts");
            System.out.print("\n4.Display list contracts");
            System.out.print("\n5.Edit contracts");
            System.out.print("\n6.Return main menu");
            System.out.print("\n7.Exit");
            System.out.print("\n===========================");
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter your choice: ");

            switch (input.nextInt()) {
                case 7:
                    System.exit(7);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static void displayPromotionManagement() {

        boolean choice = true;
        while (choice) {
            System.out.print("1.Display list customers use service");
            System.out.print("\n2.Display list customers get voucher");
            System.out.print("\n3.Return main menu");
            System.out.print("\n4.Exit");
            System.out.print("\n===========================");
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter your choice: ");

            switch (input.nextInt()) {
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
