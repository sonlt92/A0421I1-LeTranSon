package model.service;

import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServicesService {
    List<Service> displayPagination(int index);

    List<Service> showAll();

    void addNewService(Service service)throws SQLException;

    Service showServiceByID(int id);
}
