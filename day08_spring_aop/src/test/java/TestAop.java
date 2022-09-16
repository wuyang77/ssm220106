import com.atguigu.aop.Calc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void testAop(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calc calc = context.getBean("calc", Calc.class);
        int add = calc.add(1, 2);
        System.out.println("======================");
    }
}
