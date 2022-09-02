import com.aguigui.spring.controller.DeptController;
import com.aguigui.spring.dao.DeptDao;
import com.aguigui.spring.dao.impl.DeptDaoImpl;
import com.aguigui.spring.pojo.Dept;
import com.aguigui.spring.service.DeptService;
import com.aguigui.spring.service.impl.DeptServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAnnotation {
    /**
     * 测试4个注解
     */
    @Test
    public void testAnnotation(){
        //创建容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicatonContext.xml");
        //接口不能实例化，多态
//        Dept dept = context.getBean("dept", Dept.class);
        DeptDao deptDao = context.getBean("deptDao", DeptDaoImpl.class);
        DeptService deptService = context.getBean("deptService", DeptServiceImpl.class);
        DeptController deptController = context.getBean("deptController", DeptController.class);

//        System.out.println("dept = " + dept);
        System.out.println("deptDao = " + deptDao);
        System.out.println("deptService = " + deptService);
        System.out.println("deptController = " + deptController);
    }
    @Test
    public void testAnnotationProperties(){
        //创建容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicatonContext.xml");
        //接口不能实例化，多态
        Dept dept = context.getBean("dept", Dept.class);
        DeptService deptService = context.getBean("deptService", DeptServiceImpl.class);
        deptService.saveDept(dept);
    }
}
