package com.letranson.furama.repository;

import com.letranson.furama.bean.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, String> {
    Page<Service> findByServiceNameLike(Pageable pageable, String name);
}