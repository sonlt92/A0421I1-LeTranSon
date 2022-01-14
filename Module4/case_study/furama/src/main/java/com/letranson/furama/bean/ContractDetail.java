package com.letranson.furama.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractDetailId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "contractId",nullable = false,referencedColumnName = "contractId")
    @JsonBackReference
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attachServiceId",nullable = false,referencedColumnName = "attachServiceId")
    @JsonBackReference
    private AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetail(Integer contractDetailId, Integer quantity, Contract contract, AttachService attachService) {
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
