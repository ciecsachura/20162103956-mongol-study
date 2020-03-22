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

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet{
   //删除


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid=Integer.parseInt(req.getParameter("uid"));
        ResultInfo resultInfo = new ResultInfo();
        //调用adminservice方法删除
        AdminService adminService=new AdminService();
        //删除成功 返回1
        int result = adminService.deleteUser(uid);
        if (1 == result){
            resultInfo.setFlag(true);
        }else {
            resultInfo.setFlag(false);
        }
        //跳转查询所有Servlet
//        resp.sendRedirect(req.getContextPath()+"/UserPageQueryServlet");


        String s = JSON.toJSONString(resultInfo);

        resp.getWriter().print(s);
    }
}
