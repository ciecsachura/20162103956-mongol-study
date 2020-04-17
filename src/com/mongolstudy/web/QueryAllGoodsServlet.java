package com.mongolstudy.web;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.Goods;
import com.mongolstudy.dao.GoodsDao;
import com.mongolstudy.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "queryAllGoodsServlet", value = "/queryAllGoodsServlet")
public class QueryAllGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> goodsList;
        GoodsDao goodsDao = new GoodsDao();
        try {
            goodsList = goodsDao.queryAllGoods();
            request.setAttribute("goodsList", goodsList);
            String s = JSON.toJSONString(goodsList);
            response.getWriter().print(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //3、响应数据:



    }
    }

