package cn.qf.Servlet;

import cn.qf.dao.UserDao;
import cn.qf.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、设置字符编码
        req.setCharacterEncoding("utf-8");
        //2、创建User对象
        User Loginuser = new User();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3、封装成user对象
        Loginuser.setUsername(username);
        Loginuser.setPassword(password);
        //4、 //调用userDao方法
        UserDao userDao = new UserDao();
        User user = userDao.Login(Loginuser);




//        if (user == null) {
//            //请求失败
//            req.getRequestDispatcher("/failServlet").forward(req,resp);
//        }else {
//            //共享数据
//            req.setAttribute("user",user);
//            //请求成功
//            req.getRequestDispatcher("/successServlet").forward(req,resp);
//
//        }



        if (user == null) {
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            //共享
            req.setAttribute("user",user);
            //登录成功
            req.getRequestDispatcher("/successServlet").forward(req,resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
