package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void addNewCus(Customer customer) throws SQLException {
        this.customerRepository.addNewCus(customer);
    }

    @Override
    public List<Customer> showAll() {
        List<Customer> customers = this.customerRepository.showAll();
        return customers;
    }

    @Override
    public Customer showCusEdit(int id) {
        return this.customerRepository.showCusEdit(id);
    }

    @Override
    public boolean edit(Customer customer) throws SQLException {
        this.customerRepository.edit(customer);
        return false;
    }

    @Override
    public Customer showCus(int id) {
        return this.customerRepository.showCus(id);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        this.customerRepository.delete(id);
        return false;
    }
}
