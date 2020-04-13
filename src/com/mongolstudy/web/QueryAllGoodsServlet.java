package com.mongolstudy.web;

import com.mongolstudy.bean.Goods;
import com.mongolstudy.dao.GoodsDao;
import com.mongolstudy.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "queryAllGoodsServlet", value = "/queryAllGoodsServlet")
public class QueryAllGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().getAttribute("uid");
        GoodsService goodsService = new GoodsService();
        String goodsJson = GoodsService.queryAll();
        //3、响应数据:
        response.getWriter().print(goodsJson);


    }
    }

