package cn.qf.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC的工具类，使用的是durid连接池
 */
public class JDBCUtils {
   private static DataSource ds;

   static {
       try {
           //1、加载配置文件
           Properties pro = new Properties();
           //可以使用classload获取字节输入流
           InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
           pro.load(is);
           //2、初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
       } catch (IOException exception) {
           exception.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }

   }

    //1、获取连接池对象
    public static DataSource getDataSources() {
        return ds;
    }


    //2、获取连接connection对象
    public static Connection getConnection() throws SQLException {
       return ds.getConnection();
    }
}
