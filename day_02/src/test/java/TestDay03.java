import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDay03 {
    @Test
    public void testDay03_1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.selectEmpByOpt("wuyang",100.0);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
    @Test
    public void testDay03_2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setLastName("wuyang");
        employee.setSalary(100.0);

        List<Employee> employees = employeeMapper.selectEmpByPojo(employee);
        for (Employee emp : employees) {
            System.out.println("emp = " + emp);
        }
    }
    @Test
    public void testDay03_3() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.selectEmpByNamed("wuyang", 100.0);
        for (Employee employee : employeeList) {
            System.out.println("employee = " + employee);
        }

    }
    @Test
    public void testDay03_4() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String,Object> map = new HashMap<>();
        map.put("lastName","wuyang");
        map.put("salary",100.0);
        List<Employee> employeeList = employeeMapper.selectEmpByMap(map);
        for (Employee employee : employeeList) {
            System.out.println("employee = " + employee);
        }


    }
}
