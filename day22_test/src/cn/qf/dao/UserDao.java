package cn.qf.dao;

import cn.qf.domain.User;
import cn.qf.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    //声明JDBCTemplate对象来共用
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSources());
    //登录方法

    /**
     *
     * @param loginuser，用户名和密码
     * @return 用户全部数据
     */
    public User Login(User loginuser) {
        try {
            //登录逻辑，只要是2步
            //1，编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2、调用方法
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginuser.getUsername(),
                loginuser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    }
