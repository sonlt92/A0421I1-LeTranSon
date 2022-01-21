package com.letranson.furama.service;

import com.letranson.furama.bean.Contract;
import com.letranson.furama.bean.ContractDetail;

public interface ContractDetailService {
    ContractDetail findByIdContract(Contract contract);

    void save(ContractDetail contractDetail);

    void remove(Contract contract);
}