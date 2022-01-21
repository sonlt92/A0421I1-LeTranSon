package com.letranson.furama.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class RentType {
    @Id
    private Integer rentTypeId;

    private String rentTypeName;
    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Service> services;

    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName, Double rentTypeCost, Set<Service> services) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.services = services;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}