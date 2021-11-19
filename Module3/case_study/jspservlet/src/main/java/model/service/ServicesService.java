package model.service;

import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServicesService {
    public List<Service> displayPagination(int index);

    public List<Service> showAll();

    public void addNewService(Service service)throws SQLException;

    public Service showServiceByID(int id);
}
