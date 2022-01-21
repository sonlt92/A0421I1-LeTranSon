package com.letranson.furama.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String userName;

    private String passWord;

    @ManyToMany()
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "userName"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    @JsonManagedReference
    private Set<Role> roles;

    public User() {
    }

    public User(String userName, String passWord, Set<Role> roles) {
        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
