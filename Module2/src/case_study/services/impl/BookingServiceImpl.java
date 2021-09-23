package case_study.services.impl;

import case_study.models.Booking;
import case_study.models.Customer;
import case_study.models.Facility;
import case_study.models.Villa;
import case_study.services.BookingService;
import case_study.services.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        customerList.add(new Customer(1,"Ryuk",20, "Male", "194410999", "ryuk@gmail.com", "VIP", "DN" ));
        customerList.add(new Customer(2,"Cuong",22, "Male", "194410900", "cuong@gmail.com", "VIP", "DN" ));
        customerList.add(new Customer(3,"Quyen",18, "Male", "194410123", "quyen@gmail.com", "VIP", "DN" ));

        facilityIntegerMap.put(new Villa("1", "Villa 1", 200, 100, 10, "Day", "VIP", ))
    }

    @Override
    public void display() {

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
