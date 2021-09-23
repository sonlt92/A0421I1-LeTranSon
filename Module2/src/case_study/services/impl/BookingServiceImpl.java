package case_study.services.impl;

import case_study.models.Booking;
import case_study.models.Customer;
import case_study.models.Facility;
import case_study.models.Villa;
import case_study.services.BookingService;
import case_study.services.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {

    Scanner scanner = new Scanner(System.in);

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        customerList.add(new Customer(1,"Ryuk",20, "Male", "194410999", "ryuk@gmail.com", "VIP", "DN" ));
        customerList.add(new Customer(2,"Cuong",22, "Male", "194410900", "cuong@gmail.com", "VIP", "DN" ));
        customerList.add(new Customer(3,"Quyen",18, "Male", "194410123", "quyen@gmail.com", "VIP", "DN" ));

        facilityIntegerMap.put(new Villa("1", "Villa 1", 200, 100, 10, "Day", "VIP", 15, 2 ), 0);
        facilityIntegerMap.put(new Villa("2", "Villa 2", 300, 200, 20, "Day", "VIP", 16, 3 ), 0);
        facilityIntegerMap.put(new Villa("3", "Villa 3", 400, 300, 30, "Day", "VIP", 17, 4 ), 0);

    }


    @Override
    public void addBooking() {
        Scanner scanner = new Scanner(System.in);
        int id = 1;
        if (!bookingSet.isEmpty()){
            id = bookingSet.size();
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.println("Input Start Day: ");
        String startDay = scanner.nextLine();
        System.out.println("Input End Day: ");
        String endDay = scanner.nextLine();
        Booking booking = new Booking(id, startDay, endDay, customer, facility);

        bookingSet.add(booking);
        System.out.println("Add Success.");
    }

    @Override
    public void displayListBooking() {
        for (Booking booking : bookingSet){
            System.out.println(booking.toString());
        }
    }

    @Override
    public void createNewContact() {

    }

    @Override
    public void display() {

    }

    public static Customer chooseCustomer(){
        System.out.print("Customer List: ");
        for (Customer customer : customerList){
            System.out.print(customer.toString());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id customer: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());

        while (check){
            for (Customer customer : customerList){
                if (id == customer.getId()){
                    check = false;
                    return customer;
                }
            }
            if (check){
                System.out.println("You entered it wrong. Please re-enter. ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility(){
        System.out.print("Facility List: ");
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()){
            System.out.print(entry.getKey().toString());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id facility: ");
        boolean check = true;
        String id = scanner.nextLine();

        while (check){
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()){
                if (id.equals(entry.getKey().getIdFacicility())){
                    check = false;
                    return entry.getKey();
                }
            }
            if (check){
                System.out.println("You entered it wrong. Please re-enter. ");
                id = scanner.nextLine();
            }
        }
        return null;
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
