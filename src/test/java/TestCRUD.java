import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-ds.xml","classpath:spring-service.xml"})
public class TestCRUD {

    @Autowired
    private DruidDataSource druidDataSource;

    @Autowired
    private IUserService userService;

    @Test
    public void getConn() throws SQLException {
        Connection connection = druidDataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void saveUser(){
        User user = new User();
        user.setUsername("李四");
        user.setPassword("112233");
        user.setEmail("123@gmail.com");
        user.setPhone("188");
        user.setCreateTime(new Date());
        user.setCreateUser("admin");
        userService.saveUser(user);
        System.out.println(user.getId());
    }
    @Test
    public void getUserByName() {
        User user = userService.getUserByName("张三");
        System.out.println(user);
    }
}
