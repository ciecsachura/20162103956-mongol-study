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

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        String adduserJson;
        try {
            BeanUtils.populate(user,map);
            AdminService adminService = new AdminService();
            adduserJson = adminService.addUser(user);

        }catch (Exception e){
            e.printStackTrace();
            //处理异常的结果
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("数据异常，请联系管理员！");
            adduserJson = JSON.toJSONString(resultInfo);
        }
        response.getWriter().print(adduserJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
