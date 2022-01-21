package com.letranson.furama.service;

import com.letranson.furama.bean.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    Iterable<Contract> findAllNotPage();

    Contract findById(Integer id);

    void save(Contract contract);

    void delete(Contract contract);
}
