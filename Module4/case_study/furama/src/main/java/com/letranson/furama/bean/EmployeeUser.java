package com.letranson.furama.bean;

import javax.validation.constraints.*;

public class EmployeeUser {
    private String employeeId;

    @NotBlank()
    private String name;

    @NotBlank
    private String birthday;

    @NotBlank
    @Pattern(regexp = "^[0-9]{9}$",message = "The Id Card must have 9 digits and be in the format XXX XXX XXX.")
    private String idCard;

    @NotNull
    @Positive(message = "You can only enter numbers greater than 0")
    private Double salary;

    @NotBlank
    @Pattern(regexp = "^((091)|(090))[0-9]{7}$",message = "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.")
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;

    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    @NotBlank
    @Size(min = 5, max = 15)
    private String userName;

    @NotBlank
    @Size(min = 5, max = 15)
    private String passWord;

    public EmployeeUser() {
    }

    public EmployeeUser(String employeeId, String name, String birthday, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, String userName, String passWord) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
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
}
