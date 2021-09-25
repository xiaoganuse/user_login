package cn.qf.test;

import cn.qf.dao.UserDao;
import cn.qf.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void TestLogin() {
        //创建User对象
        User Loginuser = new User();
        Loginuser.setUsername("admin");
        Loginuser.setPassword("123");

        UserDao userDao = new UserDao();
        User user = userDao.Login(Loginuser);
        System.out.println(user);

    }
}
