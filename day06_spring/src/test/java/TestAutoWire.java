import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWire {
    @Test
    public void TestAutoWire(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_autowire.xml");
        DeptService deptService = context.getBean("deptService", DeptService.class);
        deptService.savaDept(new Dept());
    }
}
