package model.service;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    void addNewEmployee(Employee employee) throws SQLException;

    public List<Employee> showAll();

    public Employee showEmployee(int id);

    public boolean edit(Employee employee) throws SQLException;

    public Employee showEmployeeEdit(int id);

    public boolean delete(int id) throws SQLException;
}
