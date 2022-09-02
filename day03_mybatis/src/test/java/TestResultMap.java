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

public class TestResultMap {
    @Test
    public void testResultMap() throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        //测试自定义映射[resultMap]
        List<Employee> employees = mapper.selectEmpAndDeptByEmpId(1);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
        //测试自定义映射[association]
        Employee employee = mapper.selectEmpAndDeptByEmpIdAssociation(2);
        System.out.println("employee = " + employee);
    }
}
