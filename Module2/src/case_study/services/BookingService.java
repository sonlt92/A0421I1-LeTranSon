package case_study.services;

public interface BookingService extends Service {

    @Override
    void addBooking();

    @Override
    void displayListBooking();

    @Override
    void addNew();

    @Override
    void edit();

    @Override
    void delete();
}
