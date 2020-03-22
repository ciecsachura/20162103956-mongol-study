package com.mongolstudy.web;

import com.mongolstudy.service.AdminService;
import com.mongolstudy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userPageQueryServlet")
public class UserPageQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、接收请求数据
        String strPageNum = request.getParameter("pageNum");
        String strPageSize = request.getParameter("pageSize");
        //2、处理数据：调用service处理分页查询业务
        AdminService adminService = new AdminService();
        String pageUserJson = AdminService.pageQuery(strPageNum, strPageSize);
        //3、响应数据:pageRouteJson
        response.getWriter().print(pageUserJson);
    }
}
