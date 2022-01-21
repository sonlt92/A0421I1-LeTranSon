package com.letranson.furama.repository;

import com.letranson.furama.bean.Contract;
import com.letranson.furama.bean.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    ContractDetail findByContract(Contract contract);
}
