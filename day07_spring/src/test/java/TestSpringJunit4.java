import com.aguigui.spring.pojo.Dept;
import com.aguigui.spring.service.DeptService;
import com.aguigui.spring.service.impl.DeptServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicatonContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 1. 导入jar包 spring-test-5.3.1.jar
 * 2. 指定Spring的配置文件的路径 【@ContextConfiguration】
 * 3. 指定Spring环境下运行Junit4的运行器  @RunWith
 */
public class TestSpringJunit4 {
    @Autowired
    private DeptService deptService;
    @Test
    public void testService(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicatonContext.xml");
//        DeptServiceImpl deptService = context.getBean("deptService", DeptServiceImpl.class);

        deptService.saveDept(new Dept());
    }
}
