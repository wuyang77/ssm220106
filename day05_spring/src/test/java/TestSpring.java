import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void testSpring(){
        //使用Spring之前
//        Student student = new Student();

        //使用Spring之后
        //创建容器对象
        ApplicationContext iocObj = new ClassPathXmlApplicationContext("applicationContext.xml");

        //通过容器对象获取需要的对象
        //方式一
//        Student stuZhenzhong = (Student) iocObj.getBean("stuZhenzhong");
//        System.out.println("stuZhenzhong = " + stuZhenzhong);

        //方式二
//        Student bean = iocObj.getBean(Student.class);
//        System.o ut.println("bean = " + bean);

        //方式三(推荐使用)
//        Student stuZhenzhong = iocObj.getBean("stuZhenzhong", Student.class);
//        Student wuyang = iocObj.getBean("wuyang", Student.class);
//        System.out.println("stuZhenzhong = " + stuZhenzhong);
//        System.out.println("wuyang = " + wuyang);

        Student stuXiaoxi = iocObj.getBean("stuXiaoxi", Student.class);
        System.out.println("stuXiaoxi = " + stuXiaoxi);
    }
}
