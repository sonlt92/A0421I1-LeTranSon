package case_study.controllers;

import java.util.Scanner;

public class FuramaController {
    public String displayMainMenu(){
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.print("\n============MENU===========");
        System.out.print("\n1.Employee Management");
        System.out.print("\n2.Customer Management");
        System.out.print("\n3.Facility Management");
        System.out.print("\n4.Booking Managerment");
        System.out.print("\n5.Promotion Management");
        System.out.print("\n6.Exit");
        System.out.print("\n===========================");
        System.out.print("\nEnter your choice: ");
        choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.print("1.Display list employees");
                System.out.print("\n2.Add new employee");
                System.out.print("\n3.Edit employee");
                System.out.print("\n4.Return main menu");
                break;
            case 2:
                System.out.print("1.Display list customers");
                System.out.print("\n2.Add new customer");
                System.out.print("\n3.Edit customer");
                System.out.print("\n4.Return main menu");
                break;
            case 3:
                System.out.print("1.Display list facility");
                System.out.print("\n2.Add new facility");
                System.out.print("\n3.Edit facility maintenance");
                System.out.print("\n4.Return main menu");
                break;
            case 4:
                System.out.print("1.Add new booking");
                System.out.print("\n2.Display list booking");
                System.out.print("\n3.Create new constracts");
                System.out.print("\n4.Display list contracts");
                System.out.print("\n5.Edit contracts");
                System.out.print("\n6.Return main menu");
                break;
            case 5:
                System.out.print("1.Display list customers use service");
                System.out.print("\n2.Display list customers get voucher");
                System.out.print("\n3.Return main menu");
                break;
            case 6:
                System.exit(6);
            default:
                System.out.println("No choice!");
        }
        return displayMainMenu();
    }
}
