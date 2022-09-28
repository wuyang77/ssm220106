import com.atguigu.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

public class TestJdbcTemplate {
    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_jdbcTemplate.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println("jdbcTemplate = " + jdbcTemplate);

        //增
//        String sql1 = "insert into tbl_dept(dept_name) values(?)";
//        jdbcTemplate.update(sql1, "人事部门");
        //删
//        String sql2 = "delete from tbl_dept where dept_id = ?";
//        jdbcTemplate.update(sql2,4);
        //改
//        String sql = "update tbl_dept set dept_name = ? where dept_id = ?";
//        jdbcTemplate.update(sql,"人事2部",3);

        //批量增
//        String sql = "insert into tbl_employee(last_name,email,salary,dept_id) values(?,?,?,?)";
//        List<Object[]> employeeList = new ArrayList<>();
//        employeeList.add(new Object[]{"wuyang111","1234214@qq.com",100.0,1});
//        employeeList.add(new Object[]{"wuyang23142","1234214@qq.com",100.0,3});
//        employeeList.add(new Object[]{"wuyang12312","1234214@qq.com",100.0,2});
//        employeeList.add(new Object[]{"wuyang1342","1234214@qq.com",100.0,1});
//        employeeList.add(new Object[]{"wuyang235434","1234214@qq.com",100.0,3});
//        employeeList.add(new Object[]{"wuyang4543","1234214@qq.com",100.0,2});
//        jdbcTemplate.batchUpdate(sql,employeeList);
        //测试查询
        //查询单个数值
//        String sql = "select count(1) from tbl_employee";
//        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println("员工人数 = " + count);
        //查询单个对象
//        String sql = "select id,last_name,email,salary,dept_id from tbl_employee where id = ?";
//        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
//        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 24);
//        System.out.println("employee = " + employee);
        //查询多个对象
//        String sql = "select id,last_name,email,salary from tbl_employee";
//        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
//        List<Employee> empList = jdbcTemplate.query(sql, rowMapper);
//        for (Employee employee : empList) {
//            System.out.println("employee = " + employee);
//        }


    }
}
