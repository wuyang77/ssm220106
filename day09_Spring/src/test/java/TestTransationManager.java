import com.atguigu.service.BookShopService;
import com.atguigu.service.CashierService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

//@ContextConfiguration(locations = "classpath:applicationContext_transactionmanager.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext_transactionmanager.xml")
//@ExtendWith(SpringExtension.class)

@SpringJUnitConfig(locations = "classpath:applicationContext_transactionmanager.xml")
public class TestTransationManager {
//测试申明式事务管理的基本使用
    @Autowired
    @Qualifier("bookShopService")
    private BookShopService bookShopService;
    @Test
    public void testNoTran(){
        bookShopService.purchase("chenlong","1001");
    }

    @Autowired
    @Qualifier("cashierService")
    private CashierService cashierService;

    @Test
    public void testTransanalAttr(){
        List<String> ids = new ArrayList<>();
        ids.add("1001");
        ids.add("1002");
        cashierService.checkout("chenlong",ids);
    }
}
