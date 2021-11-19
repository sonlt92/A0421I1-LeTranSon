package model.repository;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    void addNewCus(Customer customer) throws SQLException;

    List<Customer> showAll();

    Customer showCusEdit(int id);

    boolean edit(Customer customer) throws SQLException;

    Customer showCus(int id);

    boolean delete(int id) throws SQLException;
}
