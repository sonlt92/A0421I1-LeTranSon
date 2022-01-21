package com.letranson.furama.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
public class Service {
    @Id
    private String serviceId;

    @NotBlank
    private String serviceName;

    @NotNull
    @Positive(message = "You can only enter numbers greater than 0")
    private Integer serviceArea;

    @NotNull
    @Positive(message = "You can only enter numbers greater than 0")
    private Double serviceCost;

    @NotNull
    @Positive(message = "You can only enter numbers greater than 0")
    private Integer serviceMaxPeople;

    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;

    @NotBlank
    private String linkImg;

    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId",nullable = false,referencedColumnName = "serviceTypeId")
    @JsonBackReference
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rentTypeId",nullable = false,referencedColumnName = "rentTypeId")
    @JsonBackReference
    private RentType rentType;

    public Service() {
    }

    public Service(String serviceId, String serviceName, Integer serviceArea, Double serviceCost, Integer serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, String linkImg, Set<Contract> contracts, ServiceType serviceType, RentType rentType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.linkImg = linkImg;
        this.contracts = contracts;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }
}