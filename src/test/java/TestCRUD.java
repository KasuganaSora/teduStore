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
        userService.register(user);
        System.out.println(user.getId());
    }
    @Test
    public void getUserByName() {
        User user = userService.getUserByName("张三");
        System.out.println(user);
    }
    @Test
    public void checkEmail() {
        boolean b = userService.checkEmail("ls@gmail.com");
        System.out.println(b);
        //2018年03月01日
    }

    @Test
    public void checkUsername() {
        boolean b = userService.checkUsername("博丽灵梦");
        System.out.println(b);
        if (b) {
            System.out.println("用户名可以使用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void get() {
        int m_x = 100 / 5;
        int m_y = 100 / 3;
        for (int x = 1; x <= m_x ; x++) {
            for (int y = 1; y <= m_y ; y++) {
                int z = 100 - x - y;
                if (z % 3 == 0&& 5*x+3*y+z/3==100){
                    System.out.println(x+","+y+","+z);
                }
            }
        }
    }

}
