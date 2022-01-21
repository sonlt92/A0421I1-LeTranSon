package com.letranson.furama.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    private Integer roleId;

    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<User> users;

    public Role() {
    }

    public Role(Integer roleId, String roleName, Set<User> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
