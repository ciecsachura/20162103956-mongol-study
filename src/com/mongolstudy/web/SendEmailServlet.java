package com.mongolstudy.web;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

@WebServlet(name = "SendEmailServlet",value = "/sendEmailServlet")
public class SendEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 收件人的电子邮件 ID
        String to = request.getParameter("email");
        String title = request.getParameter("title");
        title = new String(title.getBytes("iso-8859-1"),"utf-8");
        String texts = request.getParameter("texts");
        texts = new String(texts.getBytes("iso-8859-1"),"utf-8");

        // 发件人的电子邮件 ID
        String from = "ciecsachura@163.com";    //你的邮箱
        // 假设您是从本地主机发送电子邮件
        String host = "smtp.163.com";   //发送方邮箱SMTP,各种邮箱不一样,我的适用于163邮箱

        // 获取系统的属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.transport.protocol", "smtp");//使用协议
        properties.setProperty("mail.smtp.host", host);//发件人邮箱服务地址
        properties.setProperty("mail.smtp.auth", "false");//需要请求认证
        properties.setProperty("mail.smtp.port", "465");//ssl端口
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", "465");

        final String username = "ciecsachura@163.com";    //发送方邮箱账号,填你的就行了
        final String password = "bss19980218";     //发送方邮箱密码,填你的密码就行了
        properties.setProperty("mail.user", username);
        properties.setProperty("mail.password", password);

        // 获取默认的 Session 对象
        Session session = Session.getDefaultInstance(properties);

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try{
            MimeMessage mime = new MimeMessage(session);
            mime.setFrom(new InternetAddress(from));
            mime.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            mime.setSubject(title);
            mime.setText(texts);
            mime.setSentDate(new Date());
            mime.saveChanges();
            Transport transport = session.getTransport();//根据session获得邮件传输对象
            transport.connect(username,password);
            transport.sendMessage(mime, mime.getAllRecipients());
            transport.close();

            String titles = "发送电子邮件";
            String res = "成功发送消息...";
            String docType = "<!DOCTYPE html> \n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + titles + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + titles + "</h1>\n" +
                    "<p align=\"center\">" + res + "</p>\n" +
                    "</body></html>");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
