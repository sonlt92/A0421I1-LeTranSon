package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public void addNewCus(Customer customer) throws SQLException;

    public List<Customer> showAll();

    public Customer showCusEdit(int id);

    public boolean edit(Customer customer) throws SQLException;

    public Customer showCus(int id);

    public boolean delete(int id) throws SQLException;
}
