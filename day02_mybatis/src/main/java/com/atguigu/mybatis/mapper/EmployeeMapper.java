package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmployeeMapper {
    /**
     * 通过id查询员工
     */
    public Employee selectEmpById(int empId);

    /**
     * 修改员工信息
     * 1增加2删除3修改
     * @param employee
     */
    public void insertEmployee(Employee employee);
    public void deleteEmployee(int empId);
    public void updateEmployee(Employee employee);
    /**
     * 查询所有的员工信息
     */
    public List<Employee> selectAllEmps();
    public long selectCountEmps();

    /**
     * 查询多个参数传递和单个参数传递的区别
     * @param lastName
     * @param salary
     * @return
     */
    public List<Employee> selectEmpByOpt(String lastName,Double salary);

    /**
     * Pojo(javaBean)参数传递
     * @param employee
     * @return
     */
    public List<Employee> selectEmpByPojo(Employee employee);
    /**
     * 命名参数传递规则
     */
    public List<Employee> selectEmpByNamed(@Param("endName") String lastName,
                                           @Param("salary") Double salary);

    /**
     * Map参数传递
     */
    public List<Employee> selectEmpByMap(Map<String,Object> map);
    /**
     * 测试$使用场景
     */
    public List<Employee> selectEmpByDynamicTable(@Param("tblName") String tblName);

    /**
     *查询单行数据返回Map集合
     * Map<String key,Object value></>字段作为Map的key,查询结果作为Map的Value
     */
    public Map<String,Object> selectEmpReturnMap(int empId);
    /**
     *查询多行数据返回Map集合
     *Map<Integer key,Employee value></>对象id作为key,对象本身为value
     */
    @MapKey("id")
    public Map<Integer,Employee> selectEmpsReturnMap();
}

