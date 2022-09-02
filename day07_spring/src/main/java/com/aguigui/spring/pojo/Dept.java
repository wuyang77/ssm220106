package com.aguigui.spring.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component("dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 6173805002566139825L;
    @Value("101")
    private Integer deptId;
    @Value("研发部门")
    private String deptName;
    //一对多的关系：一个部门对应多个员工
    private List<Employee> empList;
    private Map<Integer,Employee> empMap;

    public Dept() {
        System.out.println("Dept构造器！！！");
    }

    public Map<Integer, Employee> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(Map<Integer, Employee> empMap) {
        this.empMap = empMap;
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

    public Dept(Integer deptId, String deptName, List<Employee> empList, Map<Integer, Employee> empMap) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.empList = empList;
        this.empMap = empMap;
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
                ", empMap=" + empMap +
                '}';
    }
}
