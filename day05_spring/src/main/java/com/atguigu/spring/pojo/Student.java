package com.atguigu.spring.pojo;

public class Student {
    private Integer studentId;
    private String stuName;

    public Student() {
    }

    public Student(Integer studentId, String stuName) {
        System.out.println("Student有参构造器！！！");
        this.studentId = studentId;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        System.out.println("setStuId()!!!");
        this.studentId = studentId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
