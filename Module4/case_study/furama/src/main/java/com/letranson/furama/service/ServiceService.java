package com.letranson.furama.service;

import com.letranson.furama.bean.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService{
    Page<Service> findAll(Pageable pageable);

    Page<Service> findByName(Pageable pageable, String name);

    Iterable<Service> findAllNotPage();

    Service findById(String id);

    void save(Service service);

    void delete(Service service);
}
