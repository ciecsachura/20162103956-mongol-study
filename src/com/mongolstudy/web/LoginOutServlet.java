package com.mongolstudy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginOutServlet")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、接收请求数据


        //2、处理数据：实现用户注销

        //2.1：销毁session中的用户数据
//        HttpSession session = request.getSession();
//        session.invalidate();
        request.getSession().invalidate();

        //2.2：跳转到登录页面：重定向到login.html
        response.sendRedirect("/login.html");


        //3、响应数据


    }
}
