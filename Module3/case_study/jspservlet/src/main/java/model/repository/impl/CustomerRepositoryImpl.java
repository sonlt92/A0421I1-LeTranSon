package model.repository.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/database_furama?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_CUS = "insert into khach_hang values (?, ?, ?, ? ,?, ?, ? ,?);";
    private static final String SELECT_ALL_CUS = "select id_khach_hang, ho_va_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi, loai_khach.ten_loai_khach \n" +
            "from khach_hang\n" +
            "\tleft join loai_khach on\tloai_khach.id_loai_khach = khach_hang.id_loai_khach;";
    private static final String SELECT_CUS_EDIT ="select id_khach_hang, ho_va_ten, ngay_sinh, so_cmnd , sdt, email, dia_chi, id_loai_khach\n" +
            "from khach_hang\n" +
            "where id_khach_hang = ?;";
    private static final String UPDATE_CUS ="update khach_hang\n" +
            "set ho_va_ten = ?, ngay_sinh = ?, so_cmnd = ?, sdt = ?, email = ?, dia_chi = ?, id_loai_khach = ?\n" +
            "where id_khach_hang = ?;";
    private static final String SELECT_CUS ="select id_khach_hang, ho_va_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi, loai_khach.ten_loai_khach \n" +
            "from khach_hang\n" +
            "\tleft join loai_khach on\tloai_khach.id_loai_khach = khach_hang.id_loai_khach\n"+
            "where id_khach_hang = ?;";
    private static final String DELETE_CUS ="delete\n" +
            "from khach_hang\n" +
            "where id_khach_hang = ?;";

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
    public void addNewCus(Customer customer) throws SQLException {
        System.out.println(INSERT_CUS);

        try (Connection connection = getConnection() ;PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUS)) {
            preparedStatement.setInt(1, customer.getIdCus());
            preparedStatement.setInt(2, Integer.parseInt(customer.getTypeOfCus()));
            preparedStatement.setString(3, customer.getNameCus());
            preparedStatement.setString(4, customer.getDateOfBirth());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Customer> showAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCus = rs.getInt("id_khach_hang");
                String name = rs.getString("ho_va_ten");
                String date = rs.getString("ngay_sinh");
                String idCard = rs.getString("so_cmnd");
                String phone = rs.getString("sdt");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                String typeCus = rs.getString("ten_loai_khach");

                customers.add(new Customer(idCus, typeCus, name, date, idCard, phone, email, address));
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return customers;
    }

    @Override
    public Customer showCusEdit(int id) {
        Customer customer = null;

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUS_EDIT)) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int idCus = rs.getInt("id_khach_hang");
                String name = rs.getString("ho_va_ten");
                String date = rs.getString("ngay_sinh");
                String idCard = rs.getString("so_cmnd");
                String phone = rs.getString("sdt");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                String typeCus = rs.getString("id_loai_khach");

                customer = new Customer(idCus,typeCus,name,date,idCard,phone,email,address);
            }

        }catch (SQLException e){
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public boolean edit(Customer customer) throws SQLException {
        boolean rowUpdated;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUS)){

            preparedStatement.setString(1, customer.getNameCus());
            preparedStatement.setString(2, customer.getDateOfBirth());
            preparedStatement.setString(3, customer.getIdCard());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getAddress());
            preparedStatement.setInt(7, Integer.parseInt(customer.getTypeOfCus()));
            preparedStatement.setInt(8, customer.getIdCus());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Customer showCus(int id) {
        Customer customer = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUS)) {
            preparedStatement.setInt(1,id);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int idCus = rs.getInt("id_khach_hang");
                String name = rs.getString("ho_va_ten");
                String date = rs.getString("ngay_sinh");
                String idCard = rs.getString("so_cmnd");
                String phone = rs.getString("sdt");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                String typeCus = rs.getString("ten_loai_khach");

                customer = new Customer(idCus,typeCus,name,date,idCard,phone,email,address);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUS);) {
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
