import com.atguigu.pojo.Dept;
import com.atguigu.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext_jdbcTemplate.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class TestJdbcTemplateService {

    @Autowired
    private DeptService deptService;

    @Test
    public void testService(){
        List<Dept> allDepts = deptService.getAllDepts();
        for (Dept allDept : allDepts) {
            System.out.println("allDept = " + allDept);
        }
    }
}
