package com.letranson.validate_form.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    @NotEmpty
    @Size(min = 5,max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5,max = 45)
    private String lastName;

    @Min(18)
    private int age;

    @NotEmpty
    @Email
    private String email;

    public User() {
    }

    public User(@NotEmpty(message = "not null") @Size(min = 5, max = 45, message = "Khong dung dinh dang.") String firstName, @Size(min = 5, max = 45, message = "Khong dung dinh dang.") String lastName, @Min(18) int age, @Email(message = "Khong dung dinh dang xyz@xyz.xyz") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
