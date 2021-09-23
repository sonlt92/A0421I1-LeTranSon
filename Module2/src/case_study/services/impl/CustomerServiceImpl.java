package case_study.services.impl;

import case_study.models.Customer;
import case_study.models.Employee;
import case_study.services.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new LinkedList<>();
    private Scanner input = new Scanner(System.in);


    @Override
    public void display() {
        for (Customer customer :
                customerList) {
            System.out.print(customer.toString());
        }

    }

    @Override
    public void addBooking() {

    }

    @Override
    public void displayListBooking() {

    }

    @Override
    public void createNewContact() {

    }

    @Override
    public void addNew() {
        System.out.print("Input ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Input Name: ");
        String name = input.nextLine();
        System.out.print("Input Age: ");
        int age = Integer.parseInt(input.nextLine());
        System.out.print("Input Sex: ");
        String sex = input.nextLine();
        System.out.print("Input ID Card: ");
        String idCard = input.nextLine();
        System.out.print("Input Email: ");
        String email = input.nextLine();
        System.out.print("Input Type Customer: ");
        String typeCustomer = input.nextLine();
        System.out.print("Input Address: ");
        String address = input.nextLine();
        Customer customer = new Customer(id, name, age, sex, idCard, email, typeCustomer, address);
        customerList.add(customer);
        System.out.print("Successfully added new customers." + "\n");
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
