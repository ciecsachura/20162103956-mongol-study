package com.mongolstudy.web;

import com.mongolstudy.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FeedbackServlet",value = "/feedbackServlet")
public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strPageNum = request.getParameter("pageNum");
        String strPageSize = request.getParameter("pageSize");
        String cname = request.getParameter("cname");
        //2、处理数据：调用service处理分页查询业务
        AdminService adminService = new AdminService();
        String pageUserJson = AdminService.msgpageQuery(strPageNum, strPageSize,cname);
        //3、响应数据:pageRouteJson
        response.getWriter().print(pageUserJson);
    }
}
