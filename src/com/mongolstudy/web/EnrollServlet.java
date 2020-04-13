package com.mongolstudy.web;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.ResultInfo;
import com.mongolstudy.bean.User;
import com.mongolstudy.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 *  接收注册数据
 */
@WebServlet("/enrollServlet")
public class EnrollServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        String registerJson;
        try {
            //1、接收请求数据： Alt+Enter
            String password = request.getParameter("password");
            String repeatpassword = request.getParameter("repeatpassword");

            if (!password.equals(repeatpassword)){
                throw new Exception("前后密码不一致");
            }else {
                //封装数据
                user.setPassword(password);

            }
            BeanUtils.populate(user,map);
            //2、处理数据：注册
            UserService userService = new UserService ();
            registerJson = userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            //处理异常的结果
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("数据异常，请联系管理员！");
            registerJson = JSON.toJSONString(resultInfo);
        }
        //3、响应数据
        response.getWriter().print(registerJson);
    }

}
