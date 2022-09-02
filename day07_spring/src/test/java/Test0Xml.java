import com.aguigui.spring.config.SpringConfig;
import com.aguigui.spring.dao.impl.DeptDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test0Xml {
    @Test
    public void tset0Xml(){

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DeptDaoImpl deptDao = context.getBean("deptDao", DeptDaoImpl.class);
        System.out.println("deptDao = " + deptDao);

    }
}
