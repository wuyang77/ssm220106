import com.atguigu.mybatis.mapper.EmpolyeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestCache {
    @Test
    public void testCache() throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从sqlSessionFactory中构建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpolyeeMapper mapper = sqlSession.getMapper(EmpolyeeMapper.class);

        Employee employee = new Employee();
        List<Employee> employees = mapper.selectEmpByOpr(employee);
        System.out.println("employees = " + employees);
        //关闭资源
        sqlSession.close();

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmpolyeeMapper mapper1 = sqlSession1.getMapper(EmpolyeeMapper.class);
        System.out.println("======================================");
        List<Employee> employees1 = mapper1.selectEmpByOpr(employee);
        System.out.println("employees1 = " + employees1);
    }
}
