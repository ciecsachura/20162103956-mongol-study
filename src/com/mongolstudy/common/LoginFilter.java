package com.mongolstudy.common;

import com.mongolstudy.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//浏览器直接请求资源时
@WebFilter(value = "/*",dispatcherTypes = DispatcherType.REQUEST)//拦截路径,拦截方式request
public class LoginFilter implements Filter {
    /**
     * 服务器关闭后，销毁filter对象，如果服务器正常关闭，会执行destroy方法，只执行一次，用于释放资源
     */
    public void destroy() {
        System.out.println("destroy.....");
    }

    /**
     * 每一次请求拦截资源时会执行，执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息进行增强


        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取资源请求路径
        String uri =request.getRequestURI();
        //2.是否包含登录相关路径,要注意排除css/js/图片/验证码等资源
        if (uri.contains("/loginServlet")||uri.contains("/getLoginUserServlet")||uri.contains("/enrollServlet")||uri.contains("/css/")||uri.contains("/js/") || uri.contains("/")){
            //包含，用于想登陆，放行
            chain.doFilter(req, resp);
        }else{
            //不包含，验证用户会否登录
            //3.从session 获取user
            Object loginUser = request.getSession().getAttribute("loginUser");
            if (loginUser!=null){
                //登录了,放行
                chain.doFilter(req, resp);
                System.out.println("用户登陆了");


            }else{
                //没登录，跳转登录页面
                request.setAttribute("login_msg","您尚未登录");
                //request.getRequestDispatcher("/table.html").forward(request,resp);
                System.out.println("用户未登录");
            }


        }
        //对response对象的响应消息进行增强
        System.out.println("loginfileter回来了");

    }

    /**
     * 服务器启动后，创建filter对象，然后调用init方法，只执行一次，用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init.....");
    }

}
