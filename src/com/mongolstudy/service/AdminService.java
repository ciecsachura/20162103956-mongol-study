package com.mongolstudy.service;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.User;
import com.mongolstudy.dao.AdminDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    AdminDao adminDao=new AdminDao();
    //增



    //删


    //改
    public int editUser(int uid) {
       return adminDao.editUser(uid);
    }



    //查
    /**
     * 查询所有的用户数据
     *
     * @return
     */
    public String queryAll() {
        //查询数据：调用dao层查询数据
        List<User> userList = adminDao.queryAll();
        //userList  ===>  JSON String
        String s = JSON.toJSONString(userList);
        return s;
    }
    public static String pageQuery(String strPageNum, String strPageSize) {
        AdminDao adminDao=new AdminDao();
        //分页数据查询处理
        //计算startIndex
        int pageNum = Integer.parseInt(strPageNum);
        int pageSize = Integer.parseInt(strPageSize);
        int startIndex = (pageNum - 1) * pageSize;
        //调用dao层处理分页数据查询
        List<User> list =adminDao.pageQuery(startIndex, pageSize);
        //分页条计算
        int totalRecord = adminDao.queryTotalRecord();
        int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        //Map 封装数据 object 存任意类型数据
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("totalPage", totalPage);
        //转为json数据类型
        String s = JSON.toJSONString(map);
        return s;
    }

    public int deleteUser(int uid) {
        return adminDao.deleteUser(uid);
    }
}
