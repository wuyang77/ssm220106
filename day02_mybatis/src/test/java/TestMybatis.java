import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void testMybatisSelect() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //通过employeeMapper获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            System.out.println("employeeMapper.getClass().getName()" + employeeMapper.getClass().getName());
            Employee employee = employeeMapper.selectEmpById(1);
            System.out.println("employee = " + employee);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMybatisInsert() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //通过employeeMapper获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee(null, "wenjun", "123124@qq.com", 50.0);
            employeeMapper.insertEmployee(employee);
            sqlSession.commit();
            System.out.println("employee.getId() = " + employee.getId());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMybatisDelete() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //通过employeeMapper获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            employeeMapper.deleteEmployee(4);
            sqlSession.commit();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMybatisUpdate() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //通过employeeMapper获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee wenjun = new Employee(3, "wenjun", "123124@qq.com", 300.0);
            employeeMapper.updateEmployee(wenjun);
            sqlSession.commit();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMybatiSelectAllEmp() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //通过employeeMapper获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            List<Employee> employees = employeeMapper.selectAllEmps();
            for (Employee employee : employees) {
                System.out.println(employee);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testMybatisSelectCountEmp() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //通过employeeMapper获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            long rows = employeeMapper.selectCountEmps();
            System.out.println("员工表一共有：" + rows + "行");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}