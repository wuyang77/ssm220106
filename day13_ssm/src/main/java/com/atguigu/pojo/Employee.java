package com.atguigu.pojo;

public class Employee {

  private Integer id; //员工ID
  private String lastName;//员工姓名
  private String email;//员工邮箱
  private Double salary;//员工薪资

  public Employee() {
  }

  public Employee(Integer id, String lastName, String email, Double salary) {
    this.id = id;
    this.lastName = lastName;
    this.email = email;
    this.salary = salary;
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

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", salary=" + salary +
        '}';
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }
}
