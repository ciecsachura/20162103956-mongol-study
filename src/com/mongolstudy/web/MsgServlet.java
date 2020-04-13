package com.mongolstudy.web;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.Message;
import com.mongolstudy.bean.Message;
import com.mongolstudy.bean.ResultInfo;
import com.mongolstudy.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/msgServlet")
public class MsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Message message = new Message();
        String messageJson;
        try {
            BeanUtils.populate(message,map);
            UserService userService = new UserService ();
            messageJson = userService.message(message);
        } catch (Exception e) {
            e.printStackTrace();
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("!!!没提交成功");
            messageJson = JSON.toJSONString(resultInfo);
        }

        //2、处理数据：


        response.getWriter().print(messageJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
