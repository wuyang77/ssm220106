package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {

  public List<Employee> selectAllEmps();

}
