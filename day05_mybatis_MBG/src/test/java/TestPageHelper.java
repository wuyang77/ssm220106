import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import com.atguigu.mybatis.pojo.EmployeeExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestPageHelper  {
    /**
     * 测试开启分页
     * @throws IOException
     */
    @Test
    public void testageHelper () throws IOException {
        //创建sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        EmployeeExample ee = new EmployeeExample();
        //开启分页
        Page<Object> page = PageHelper.startPage(1, 3);
        //查询数据
        List<Employee> employees = mapper.selectByExample(ee);
        //查询之后,封装到PageInfo
        PageInfo<Employee> pageInfo = new PageInfo<>(employees, 5);
        //分页的数据如下
        System.out.println("pageInfo.getPages() = " + pageInfo.getPages());
        System.out.println("总数据数量：" + pageInfo.getTotal());
        System.out.println("每页显示数据数量：" + pageInfo.getTotal());
        System.out.println("当前页显示数据集合：" + pageInfo.getTotal());
        for (Employee employee : pageInfo.getList()) {
            System.out.println("employee = " + employee);
        }

//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }
//        System.out.println(page.getPageNum()+"/"+page.getPages());
//        Sys tem.out.println("总数据数量："+page.getTotal());
//        System.out.println("page.getPageSize() = " + page.getPageSize());
//        System.out.println("page.getResult() = " + page.getResult());
//        for (Object o : page.getResult()) {
//            System.out.println("o = " + o);
//        }
//    }
    }
}
