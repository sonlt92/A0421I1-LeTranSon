package com.letranson.furama.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {
    @Id
    private Integer positionId;

    private String name;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employees;

    public Position() {
    }

    public Position(Integer positionId, String name, Set<Employee> employees) {
        this.positionId = positionId;
        this.name = name;
        this.employees = employees;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
