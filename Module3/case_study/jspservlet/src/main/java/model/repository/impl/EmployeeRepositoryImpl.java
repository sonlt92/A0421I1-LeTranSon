package model.repository.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama-resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";


    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO nhan_vien" + "  (id_nhan_vien, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ho_va_ten) VALUES " +
            " (?, ?, ?,?,?,?,?,?,?,?, ?);";
    private static final String SELECT_ALL_EMPLOYEE = "select id_nhan_vien, ho_va_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, bo_phan.ten_bo_phan, vi_tri.ten_vi_tri, trinh_do.ten_trinh_do\n" +
            "from nhan_vien\n" +
            "left join vi_tri on vi_tri.id_vi_tri = nhan_vien.id_vi_tri\n" +
            "    left join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan\n" +
            "    left join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do";
    private static final String SELECT_EMPLOYEE_BY_ID = "select ho_va_ten, ngay_sinh, so_cmnd, so_dien_thoai, email, id_trinh_do, id_vi_tri, id_bo_phan, dia_chi, luong, id_nhan_vien\n" +
            "from nhan_vien\n" +
            "where id_nhan_vien = ?;";
    private static final String UPDATE_EMPLOYEE = "update nhan_vien\n" +
            "    set id_vi_tri= ?,id_trinh_do = ?,id_bo_phan = ?,ngay_sinh = ?,so_cmnd = ?, luong = ?, so_dien_thoai = ?, email = ?, dia_chi = ?,ho_va_ten = ?\n" +
            "    where id_nhan_vien = ? ;";
    private static final String SELECT_EMPLOYEE_EDIT = "select id_nhan_vien, ho_va_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, bo_phan.ten_bo_phan, vi_tri.ten_vi_tri, trinh_do.ten_trinh_do\n" +
            "from nhan_vien\n" +
            "left join vi_tri on vi_tri.id_vi_tri = nhan_vien.id_vi_tri\n" +
            "    left join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan\n" +
            "    left join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do\n"+
            "    where id_nhan_vien = ? ;";
    private static final String DELETE_EMPLOYEE = "delete from nhan_vien where id_nhan_vien = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void addNewEmployee(Employee employee) throws SQLDataException {
        System.out.println(INSERT_EMPLOYEE_SQL);

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setInt(1, employee.getIdEmployee());
            preparedStatement.setInt(2, Integer.parseInt(employee.getWorkPosition()));
            preparedStatement.setInt(3, Integer.parseInt(employee.getLevel()));
            preparedStatement.setInt(4, Integer.parseInt(employee.getWorkingParts()));
            preparedStatement.setString(5, employee.getDateOfBirth());
            preparedStatement.setString(6, employee.getId());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhone());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setString(11, employee.getNameOfEmployee());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    @Override
    public List<Employee> showAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Employee> employees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ho_va_ten");
                String date = rs.getString("ngay_sinh");
                String id = rs.getString("so_cmnd");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String level = rs.getString("trinh_do.ten_trinh_do");
                String position = rs.getString("vi_tri.ten_vi_tri");
                String workingParts = rs.getString("bo_phan.ten_bo_phan");
                String address = rs.getString("dia_chi");
                int salary = rs.getInt("luong");
                int idEmployee = rs.getInt("id_nhan_vien");
                employees.add(new Employee(idEmployee, name, date, email, id, phone, level, address, salary, position, workingParts));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public Employee showEmployee(int id) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        Employee employees = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ho_va_ten");
                String date = rs.getString("ngay_sinh");
                String idCard = rs.getString("so_cmnd");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String level = rs.getString("id_trinh_do");
                String position = rs.getString("id_vi_tri");
                String workingParts = rs.getString("id_bo_phan");
                String address = rs.getString("dia_chi");
                int salary = rs.getInt("luong");
                int idEmployee = rs.getInt("id_nhan_vien");
                employees = new Employee(idEmployee, name, date, email, idCard, phone, level, address, salary, position, workingParts);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public boolean edit(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);) {
            statement.setInt(1, Integer.parseInt(employee.getWorkPosition()));
            statement.setInt(2, Integer.parseInt(employee.getLevel()));
            statement.setInt(3, Integer.parseInt(employee.getWorkingParts()));
            statement.setString(4, employee.getDateOfBirth());
            statement.setString(5, employee.getId());
            statement.setInt(6, employee.getSalary());
            statement.setString(7, employee.getPhone());
            statement.setString(8, employee.getEmail());
            statement.setString(9, employee.getAddress());
            statement.setString(10, employee.getNameOfEmployee());
            statement.setInt(11, employee.getIdEmployee());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Employee showEmployeeEdit(int id) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        Employee employees = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_EDIT)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ho_va_ten");
                String date = rs.getString("ngay_sinh");
                String idCard = rs.getString("so_cmnd");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String level = rs.getString("trinh_do.ten_trinh_do");
                String position = rs.getString("vi_tri.ten_vi_tri");
                String workingParts = rs.getString("bo_phan.ten_bo_phan");
                String address = rs.getString("dia_chi");
                int salary = rs.getInt("luong");
                int idEmployee = rs.getInt("id_nhan_vien");
                employees = new Employee(idEmployee, name, date, email, idCard, phone, level, address, salary, position, workingParts);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
