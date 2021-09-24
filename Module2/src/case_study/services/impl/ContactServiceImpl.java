package case_study.services.impl;

import case_study.models.Booking;
import case_study.models.Contract;
import case_study.services.ContactService;

import java.util.*;

public class ContactServiceImpl implements ContactService {

    static List<Contract> contractList = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    @Override
    public void createNewContact() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
    }

    @Override
    public void displayListContact() {

    }

    @Override
    public void addBooking() {

    }

    @Override
    public void displayListBooking() {

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
