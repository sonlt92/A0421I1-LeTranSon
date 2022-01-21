package com.letranson.furama.repository;

import com.letranson.furama.bean.Contract;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
