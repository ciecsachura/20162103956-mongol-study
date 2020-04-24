package com.mongolstudy.service;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.Message;
import com.mongolstudy.bean.ResultInfo;
import com.mongolstudy.bean.User;
import com.mongolstudy.dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/7/22 9:27
 * @description:
 */
public class UserService {
    UserDao userDao = new UserDao();

    /**
     * 处理注册业务的方法
     *
     * @param user
     * @return
     */
    public String register(User user) {
        //0：添加了0条数据--添加失败    1：添加成功
        int addFlag = userDao.addUser(user);
        //封装结果
        ResultInfo resultInfo = new ResultInfo();
        if (addFlag == 0) {
            resultInfo.setFlag(false);
        } else {
            resultInfo.setFlag(true);
        }
        String s = JSON.toJSONString(resultInfo);
        return s;
    }

    /**
     * 处理用户登录业务
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        //处理用户登录业务：调用dao层拿用户输入的username，password到数据库中查询数据
        User user = userDao.queryByUsernameAndPassword(username, password);
        //返回查询结果
        return user;
    }

    /**
     * 处理留言
     */
    public String message(Message message) {
        ResultInfo resultInfo = new ResultInfo();
        int addFlag = userDao.addmessage(message);
        if (addFlag == 0) {
            resultInfo.setFlag(false);
        } else {
            resultInfo.setFlag(true);
        }
        String s = JSON.toJSONString(resultInfo);
        return s;
    }

   /* public static String queryAll() {
        //查询数据：调用dao层查询数据
        List<studytime> studytimeList = userDao.queryStudyTime();
        //userList  ===>  JSON String
        String s = JSON.toJSONString(studytimeList);
        return s;
    }*/
}
