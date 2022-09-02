import com.atguigu.mybatis.mapper.EmpolyeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestDynamicSql {
    /**
     * 测试if-where
     * @throws IOException
     */
    @Test
    public void testDynamicSqlIfWhere() throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpolyeeMapper empolyeeMapper = sqlSession.getMapper(EmpolyeeMapper.class);
        Employee employee = new Employee();
        employee.setId(2);
        employee.setLastName("wuyang77");
        employee.setSalary(100.00);
        employee.setEmail("2388958622@qq.com");
        List<Employee> employees = empolyeeMapper.selectEmpByOpr(employee);
        for (Employee employee1 : employees) {
            System.out.println("employee1 = " + employee1);
        }
    }

    /**
     * 测试trim
     * @throws IOException
     */
    @Test
    public void testDynamicSqlTrim() throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpolyeeMapper empolyeeMapper = sqlSession.getMapper(EmpolyeeMapper.class);
        Employee employee = new Employee();
//        employee.setId(2);
//        employee.setLastName("wuyang77");
//        employee.setSalary(100.00);
//        employee.setEmail("2388958622@qq.com");
        List<Employee> employees = empolyeeMapper.selectEmpByOprTrim(employee);
        for (Employee employee1 : employees) {
            System.out.println("employee1 = " + employee1);
        }
    }
    /**
     * 测试修改
     * @throws IOException
     */
    @Test
    public void testDynamicSqlUpdate() throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpolyeeMapper empolyeeMapper = sqlSession.getMapper(EmpolyeeMapper.class);
        Employee employee = new Employee();
        employee.setId(3);
        employee.setLastName("wuyang777");
        employee.setSalary(100.00);
        employee.setEmail("2388958622@qq.com");

        //测试多个条件查询
//       empolyeeMapper.updateEmpByOpr(employee);

        //测试单个条件查询
        List<Employee> employees = empolyeeMapper.updateEmpByOneOpr(employee);
        for (Employee employee1 : employees) {
            System.out.println("employee1 = " + employee1);
        }
        //提交事务
        sqlSession.commit();
    }

    @Test
    public void testDynamicSqlForeach() throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpolyeeMapper empolyeeMapper = sqlSession.getMapper(EmpolyeeMapper.class);

        //测试foreach
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Employee> employees = empolyeeMapper.selectEmpByIds(ids);
        for (Employee employee1 : employees) {
            System.out.println("employee1 = " + employee1);
        }

        //提交事务
        sqlSession.commit();
    }
    @Test
    public void testDynamicSqlBatchInsertEmp() throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpolyeeMapper empolyeeMapper = sqlSession.getMapper(EmpolyeeMapper.class);


        //测试批量添加信息
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(null,"zahngsan","2388958622@qq.com",100.5));
        employees.add(new Employee(null,"wangwu","2388958622@qq.com",100.5));
        employees.add(new Employee(null,"laoliu","2388958622@qq.com",100.5));
        empolyeeMapper.batchInsertEmp(employees);

        //提交事务
        sqlSession.commit();
    }
}
