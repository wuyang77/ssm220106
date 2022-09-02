
import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import com.atguigu.mybatis.pojo.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMBG {
    /**
     * 测试代码生成器
     * @throws XMLParserException
     * @throws IOException
     * @throws InvalidConfigurationException
     * @throws SQLException
     * @throws InterruptedException
     */
    @Test
    public void test() throws XMLParserException, IOException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src/main/resources/mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    /**
     * 测试QBC风格的CRUD
     * @throws IOException
     */
    @Test
    public void testCRUD() throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

//        Employee employee = mapper.selectByPrimaryKey(1);
//        System.out.println("employee = " + employee);

        //创建员工对应的条件对象
        EmployeeExample ee = new EmployeeExample();
        //创建条件对象
        EmployeeExample.Criteria criteria = ee.createCriteria();
        //添加条件
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        criteria.andIdIn(ids);
        criteria.andLastNameLike("wu%");
        List<Employee> employees = mapper.selectByExample(ee);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
}
