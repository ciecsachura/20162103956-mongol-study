package com.mongolstudy.web;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.ResultInfo;
import com.mongolstudy.bean.User;
import com.mongolstudy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.Location;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    /**
     * 处理用户登录业务
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、接收请求数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2、处理数据：调用service层处理登录业务
        UserService userService = new UserService();
        //service层处理登录业务
        User loginUser = userService.login(username, password);

        //封装结果
        ResultInfo resultInfo = new ResultInfo();
        if (loginUser == null) {
            //loginUser中没有查到数据：登录失败
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("ᠨᠡᠷ᠎ᠡ ᠪᠤᠶᠤ ᠨᠢᠭᠤᠴᠠ ᠨᠤᠮᠸᠷ ᠪᠤᠷᠤᠭᠤᠳᠠᠵᠠᠢ Нэр буюу нууц номер бурууджээ");
        } else {
            //登录成功:1、设置登录成功的状态；2、服务器内部共享用户数据；HttpSession setAttribute 提取数据
            resultInfo.setFlag(true);
            req.getSession().setAttribute("loginUser", loginUser);
            if (loginUser.getAdmin().equals(null)){
                resp.sendRedirect("/index.html");
            }else{
                resp.sendRedirect("/table.html");
            }

        }
        //3、响应数据：JSON数据（JSON字符串）
        //把resultInfo转换成JSON字符串
        String s = JSON.toJSONString(resultInfo);
        resp.getWriter().print(s);


    }
}
