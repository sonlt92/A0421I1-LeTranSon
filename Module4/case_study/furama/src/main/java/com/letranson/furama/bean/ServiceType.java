package com.letranson.furama.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class ServiceType {

    @Id
    private Integer serviceTypeId;

    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Service> services;

    public ServiceType() {
    }

    public ServiceType(Integer serviceTypeId, String serviceTypeName, Set<Service> services) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.services = services;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
