package com.letranson.furama.service.impl;

import com.letranson.furama.bean.Contract;
import com.letranson.furama.bean.ContractDetail;
import com.letranson.furama.repository.ContractDetailRepository;
import com.letranson.furama.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public ContractDetail findByIdContract(Contract contract) {
        return contractDetailRepository.findByContract(contract);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Contract contract) {
        contractDetailRepository.delete(contractDetailRepository.findByContract(contract));
    }
}
