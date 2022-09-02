import com.atguigu.mybatis.pojo.Dept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {

    @Test
    public void testScope(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_beanScope.xml");
        Dept dept = context.getBean("dept", Dept.class);
        Dept dept1 = context.getBean("dept",Dept.class);
        System.out.println("是否为一个对象？" + (dept == dept1));

    }
}
