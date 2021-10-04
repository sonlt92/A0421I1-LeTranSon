package case_study.services.impl;

import case_study.models.Employee;
import case_study.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

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
    public void displayListContact() {

    }

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

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
        System.out.print("Input Level: ");
        String level = input.nextLine();
        System.out.print("Input Position: ");
        String position = input.nextLine();
        System.out.print("Input Salary: ");
        int salary = Integer.parseInt(input.nextLine());
        Employee employee = new Employee(id, name, age, sex, idCard, email, level, position, salary);
        employeeList.add(employee);
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
