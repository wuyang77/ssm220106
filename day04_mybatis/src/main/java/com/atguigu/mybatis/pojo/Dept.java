package com.atguigu.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {

    private static final long serialVersionUID = 6173805002566139825L;
    private Integer deptId;
    private String deptName;

    //一对多的关系：一个部门对应多个员工
    private List<Employee> empList;
    public Dept() {
    }

    public Dept(Integer deptId, String deptName, List<Employee> empList) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.empList = empList;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                '}';
    }
}
