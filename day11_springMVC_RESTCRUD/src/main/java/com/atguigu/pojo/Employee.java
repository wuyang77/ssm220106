package com.atguigu.pojo;

import java.util.List;

public class Employee {
  private Integer id; //员工ID
  private String lastName;//员工姓名
  private String email;//员工邮箱
  private Integer gender;//员工薪资
  private Department department; //员工所属的不猛信息

  public Employee() {
  }

  public Employee(Integer id, String lastName, String email, Integer gender,
      Department department) {
    this.id = id;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.department = department;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", gender=" + gender +
        ", department=" + department +
        '}';
  }
}
