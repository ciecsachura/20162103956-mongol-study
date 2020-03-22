package com.mongolstudy.web;

import com.mongolstudy.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/7/23 15:42
 * @description:
 */
@WebServlet("/routePageQueryServlet")
public class RoutePageQueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、接收请求数据
        String strPageNum = request.getParameter("pageNum");
        String strPageSize = request.getParameter("pageSize");

        //2、处理数据：调用service处理分页查询业务
        RouteService routeService = new RouteService();
        String pageRouteJson = routeService.pageQuery(strPageNum, strPageSize);

        //3、响应数据:pageRouteJson
        response.getWriter().print(pageRouteJson);

    }
}
