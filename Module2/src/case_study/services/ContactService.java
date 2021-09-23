package case_study.services;

public interface ContactService extends Service {


    @Override
    void addBooking();

    @Override
    void displayListBooking();

    @Override
    void display();

    @Override
    void addNew();

    @Override
    void edit();

    @Override
    void delete();
}
