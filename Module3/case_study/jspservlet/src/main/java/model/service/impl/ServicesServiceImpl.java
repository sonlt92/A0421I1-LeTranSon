package model.service.impl;

import model.bean.Service;
import model.repository.ServicesRepository;
import model.repository.impl.ServicesRepositoryImpl;
import model.service.ServicesService;

import java.sql.SQLException;
import java.util.List;

public class ServicesServiceImpl implements ServicesService {
    ServicesRepository servicesRepository = new ServicesRepositoryImpl();

    @Override
    public List<Service> displayPagination(int index) {
        return this.servicesRepository.displayPagination(index);
    }

    @Override
    public List<Service> showAll() {
        return this.servicesRepository.showAll();
    }

    @Override
    public void addNewService(Service service) throws SQLException {
        this.servicesRepository.addNewService(service);
    }

    @Override
    public Service showServiceByID(int id) {
        return this.servicesRepository.showServiceByID(id);
    }
}
