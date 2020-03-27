package com.mongolstudy.web;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.ResultInfo;
import com.mongolstudy.bean.User;
import com.mongolstudy.service.AdminService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateJson = null;
        Map<String, String[]> map = request.getParameterMap();
        request.getParameter("uid");
        User user = new User();
        try {
            BeanUtils.populate(user,map);
            AdminService adminService = new AdminService();
            updateJson=adminService.updateUser(user);

        } catch (Exception e) {
            e.printStackTrace();
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(true);
            resultInfo.setErrorMsg("数据异常，请联系管理员！");
            updateJson = JSON.toJSONString(resultInfo);
        }
        response.getWriter().print(updateJson);
    }

}
