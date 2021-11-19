package model.repository;

import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServicesRepository {
    List<Service> displayPagination(int index);

    void addNewService(Service service)throws SQLException;

    List<Service> showAll();

    Service showServiceByID(int id);
}
