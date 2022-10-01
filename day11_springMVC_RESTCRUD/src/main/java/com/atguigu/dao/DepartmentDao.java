package com.atguigu.dao;

import com.atguigu.pojo.Department;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {
  private static Map<Integer,Department> departments = null;
  static{
    departments = new HashMap<>();
    departments.put(101,new Department(101,"D-AA"));
    departments.put(102,new Department(102,"D-BB"));
    departments.put(103,new Department(103,"D-CC"));
    departments.put(104,new Department(104,"D-DD"));
    departments.put(105,new Department(105,"D-EE"));
  }

  /**
   * 获取所有的部门信息
   * @return
   */
  public Collection<Department> getDepartments(){
    return departments.values();
  }

  /**
   * 通过部门id获取部门
   * @param id
   * @return
   */
  public Department getDepartment(Integer id){return departments.get(id);}
}
