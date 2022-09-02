import com.atguigu.mybatis.pojo.Student;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {
    @Test
    public void testLifeCycle(){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application_Context_lifeCycle.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println("4.使用Student" + student);
        //关闭容器对象才会调用销毁
        context.close();
        //装配后置处理器会为当前容器中每个Bean均装配，不能为局部Bean装配后置处理器
    }
}
