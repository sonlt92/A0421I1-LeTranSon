package model.repository.impl;

import model.bean.Service;
import model.repository.ServicesRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicesRepositoryImpl implements ServicesRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/database_furama?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String  SELECT_PAGINATION = "with x as( select row_number() over (order by id_dich_vu asc) as row_num, id_dich_vu, ten_dich_vu, dien_tich , so_tang , so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, link_anh\n" +
            "from dich_vu)\n" +
            "select * from x where row_num between ?*3-2 and ?*3;";
    private static final String INSERT_SERVICE ="insert into dich_vu(id_dich_vu, ten_dich_vu, dien_tich , so_tang , so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, link_anh)\n" +
            "values(?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL ="select id_dich_vu, ten_dich_vu, dien_tich , so_tang , so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, link_anh\n" +
            "from dich_vu;";
    private static final String SELECT_BY_ID = "select id_dich_vu, ten_dich_vu, dien_tich , so_tang , so_nguoi_toi_da, chi_phi_thue, kieu_thue.ten_kieu_thue, loai_dich_vu.ten_loai_dich_vu, link_anh\n" +
            "from dich_vu\n" +
            "\tleft join kieu_thue on kieu_thue.id_kieu_thue = dich_vu.id_kieu_thue\n" +
            "    left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu\n" +
            "    where id_dich_vu = ?;";

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
    public List<Service> displayPagination(int index) {
        List<Service> serviceList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAGINATION)){
            preparedStatement.setInt(1,index);
            preparedStatement.setInt(2,index);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                int areaUsed = resultSet.getInt("dien_tich");
                int numOfFloors = resultSet.getInt("so_tang");
                int maxPeople = resultSet.getInt("so_nguoi_toi_da");
                int rentalCost = resultSet.getInt("chi_phi_thue");
                String rentalType = String.valueOf(resultSet.getInt("id_kieu_thue"));
                String typeOfService = String.valueOf(resultSet.getInt("id_loai_dich_vu"));
                String linkImg = resultSet.getString("link_anh");

                serviceList.add(new Service(id,name,areaUsed,numOfFloors,maxPeople,rentalCost,rentalType,typeOfService,linkImg));
            }

        }catch (SQLException ex){
            printSQLException(ex);
        }

        return serviceList;
    }

    @Override
    public void addNewService(Service service) throws SQLException {
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE)){
            preparedStatement.setInt(1,service.getIdService());
            preparedStatement.setString(2,service.getName());
            preparedStatement.setInt(3,service.getAreaUsed());
            preparedStatement.setInt(4,service.getNumOfFloors());
            preparedStatement.setInt(5,service.getMaxPeoples());
            preparedStatement.setInt(6,service.getRentalCosts());
            preparedStatement.setInt(7, Integer.parseInt(service.getRentalType()));
            preparedStatement.setInt(8, Integer.parseInt(service.getTypeOfService()));
            preparedStatement.setString(9,service.getLinkImg());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            printSQLException(ex);
        }
    }

    @Override
    public List<Service> showAll() {
        List<Service> serviceList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                int areaUsed = resultSet.getInt("dien_tich");
                int numOfFloors = resultSet.getInt("so_tang");
                int maxPeople = resultSet.getInt("so_nguoi_toi_da");
                int rentalCost = resultSet.getInt("chi_phi_thue");
                String rentalType = String.valueOf(resultSet.getInt("id_kieu_thue"));
                String typeOfService = String.valueOf(resultSet.getInt("id_loai_dich_vu"));
                String linkImg = resultSet.getString("link_anh");

                serviceList.add(new Service(id,name,areaUsed,numOfFloors,maxPeople,rentalCost,rentalType,typeOfService,linkImg));

            }

        }catch (SQLException ex){
            printSQLException(ex);
        }

        return serviceList;
    }

    @Override
    public Service showServiceByID(int id) {
        Service service = null;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_BY_ID)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int idService = resultSet.getInt("id_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                int areaUsed = resultSet.getInt("dien_tich");
                int numOfFloors = resultSet.getInt("so_tang");
                int maxPeople = resultSet.getInt("so_nguoi_toi_da");
                int rentalCost = resultSet.getInt("chi_phi_thue");
                String rentalType = resultSet.getString("kieu_thue.ten_kieu_thue");
                String typeOfService = resultSet.getString("loai_dich_vu.ten_loai_dich_vu");
                String linkImg = resultSet.getString("link_anh");

                service = new Service(idService,name,areaUsed,numOfFloors,maxPeople,rentalCost,rentalType,typeOfService,linkImg);

            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return service;
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
