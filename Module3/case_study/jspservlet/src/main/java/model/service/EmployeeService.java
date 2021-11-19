package model.service;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    void addNewEmployee(Employee employee) throws SQLException;

    List<Employee> showAll();

    Employee showEmployee(int id);

    boolean edit(Employee employee) throws SQLException;

    Employee showEmployeeEdit(int id);

    boolean delete(int id) throws SQLException;
}
