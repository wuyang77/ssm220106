import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.atguigu.mybatis.factory.MyfactoryBean;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class TestSpring {
    /**
     * 测试第三方Bean
     */
    @Test
    public void testMyFactoryBean(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext_factorybean.xml");
        Dept dept = ioc.getBean("myFactoryBean", Dept.class);
        System.out.println("dept = " + dept);

    }


    /**
     * 测试Druid
     */
    @Test
    public void testDruidDataSource() throws SQLException {
        //获取容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext_druid.xml");
        DruidDataSource dataSource = ioc.getBean("DataSource", DruidDataSource.class);
        System.out.println("dataSource = " + dataSource);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }
    /**
     * 测试spring的依赖注入
     */
    @Test
    public void testIOC(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Employee employee = ioc.getBean("empChai", Employee.class);
//        System.out.println("employee = " + employee);

        //获取empXin
//        Employee empXin = ioc.getBean("empXin", Employee.class);
//        System.out.println("empXin = " + empXin);

        //获取dept1
//        Dept dept1= ioc.getBean("dept1", Dept.class);
//        System.out.println("dept1 = " + dept1);

        //获取List集合
//        Dept dept2= ioc.getBean("dept2", Dept.class);
//        System.out.println("dept2 = " + dept2);
        //获取Map集合
        Dept dept6= ioc.getBean("dept6", Dept.class);
        System.out.println("dept6 = " + dept6);
    }
}
