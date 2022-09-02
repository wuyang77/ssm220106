import com.atguigu.beforeaop.Calc;
import com.atguigu.beforeaop.CalcImpl;
import com.atguigu.beforeaop.MyProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = "classpath:applicationContext_beforeAop.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class  TestBeforeAop {
    @Autowired
    private Calc calc;
    @Test
    public void testBeforeAop(){
//        int add = calc.add(1, 2);
//        System.out.println("add = " + add);
        //目标对象
        Calc calc = new CalcImpl();
        //代理工具类
        MyProxy myProxy = new MyProxy(calc);
        //获取代理对象
        Calc calcProxy = (Calc) myProxy.getProxyObject();
        System.out.println(calcProxy.getClass().getName());
        //代理对象和目标对象不能相互转换，因为他们是兄弟关系
        //代理对象和目标对象不能相互转换，因为他们是兄弟关系
        //代理对象和目标对象不能相互转换，因为他们是兄弟关系
//        CalcImpl calcProxy = (CalcImpl) myProxy.getProxyObject();
        //测试
//        int add = calcProxy.add(1, 2);
        int sub = calcProxy.sub(57, 17);
    }
}
