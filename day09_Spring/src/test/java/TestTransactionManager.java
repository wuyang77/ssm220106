import com.atguigu.service.BookShopService;
import com.atguigu.service.CashierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext_transactionmannager.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTransactionManager {

    @Autowired
//    @Qualifier("bookShopService")
//    private BookShopService bookShopService;
    @Qualifier("cashierService")
    private CashierService cashierService;

    /**
     * 测试声明式事务管理的基本使用
     */
//    @Test
//    public void testNoTran(){
//        bookShopService.purchase("chenlong","1002");
//    }
    /**
     * 测试声明式事务管理的属性
     */
    @Test
    public void testTransanalAttr(){
        List<String> ids = new ArrayList<>();
        ids.add("1001");
        ids.add("1002");
        cashierService.checkout("chenlong",ids);
    }


}
