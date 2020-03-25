package com.mongolstudy.web;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.ResultInfo;
import com.mongolstudy.bean.User;
import com.mongolstudy.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editUserServlet")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int uid =Integer.parseInt(request.getParameter("uid"));
        //将user存入request

        request.getSession().setAttribute("user",uid);
        ResultInfo resultInfo = new ResultInfo();
        //调用adminservice方法删除
        AdminService adminService=new AdminService();
        String pageUserJson = adminService.editUser(uid);
        response.getWriter().print(pageUserJson);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
