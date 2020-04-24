package com.mongolstudy.web;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.Studytime;
import com.mongolstudy.dao.GoodsDao;
import com.mongolstudy.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryOneStudyTimeServlet",value = "/queryOneStudyTimeServlet")
public class QueryOneStudyTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Studytime> studytimeList;
        UserDao userDao = new UserDao();
        try {
            studytimeList = userDao.queryOneStudyTime();
            request.setAttribute("studytimeList", studytimeList);
            String s = JSON.toJSONString(studytimeList);
            response.getWriter().print(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
