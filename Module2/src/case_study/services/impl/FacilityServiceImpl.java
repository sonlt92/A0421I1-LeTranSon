package case_study.services.impl;

import case_study.models.Employee;
import case_study.models.Facility;
import case_study.models.Villa;
import case_study.services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private Scanner input = new Scanner(System.in);
    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()){
            System.out.print("Service " + element.getKey() + "Number of times rented: " + element.getValue() + "\n");
        }
    }

    @Override
    public void displayMaintain() {

    }

    @Override
    public void addNewVilla() {
        System.out.print("Input ID: ");
        String id = input.nextLine();
        System.out.print("Input Name: ");
        String name = input.nextLine();
        System.out.print("Input Area: ");
        double area = Double.parseDouble(input.nextLine());
        System.out.print("Input Price: ");
        int price = Integer.parseInt(input.nextLine());
        System.out.print("Input Amount Of People: ");
        int people = Integer.parseInt(input.nextLine());
        System.out.print("Input Rental Type: ");
        String rentalType = input.nextLine();
        System.out.print("Input Standard: ");
        String standard = input.nextLine();
        System.out.print("Input Area Pool: ");
        double areaPool = Double.parseDouble(input.nextLine());
        System.out.print("Input Floor: ");
        int floor = Integer.parseInt(input.nextLine());

        Villa villa = new Villa(id, name, area, price, people, rentalType, standard, areaPool, floor);
        facilityIntegerMap.put(villa, 0);
        System.out.print("Successfully added new Villa." + "\n");
    }

    @Override
    public void addNewHouse() {

    }

    @Override
    public void addNewRoom() {

    }

    @Override
    public void addNew() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
