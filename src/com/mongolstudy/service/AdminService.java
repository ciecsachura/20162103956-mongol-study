package com.mongolstudy.service;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.Message;
import com.mongolstudy.bean.ResultInfo;
import com.mongolstudy.bean.User;
import com.mongolstudy.dao.AdminDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    private AdminDao adminDao = new AdminDao();

    //增
    public String addUser(User user) {
        int addFlag = adminDao.addUser(user);
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


    //删
    public int deleteUser(int uid) {
        return adminDao.deleteUser(uid);
    }


    //查找用户
    public String findUserById(int uid) {
        User user = adminDao.queryById(uid);
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        //转为json数据类型
        String s = JSON.toJSONString(map);
        return s;
    }


    /**
     * 改
     * @param user
     * @return
     */
    public String updateUser(User user) {
        //0：添加了0条数据--添加失败    1：添加成功
        int addFlag = adminDao.updateUser(user);
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

    /**
     * 普通用户分页查询
     *
     * @param strPageNum
     * @param strPageSize
     * @return
     */
    public static String pageQuery(String strPageNum, String strPageSize, String cname) {
        AdminDao adminDao = new AdminDao();
        //分页数据查询处理
        //计算startIndex
        int pageNum = Integer.parseInt(strPageNum);
        int pageSize = Integer.parseInt(strPageSize);
        int startIndex = (pageNum - 1) * pageSize;
        //调用dao层处理分页数据查询
        List<User> list = adminDao.pageQuery(startIndex, pageSize, cname);
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

    /**
     * 反馈分页查询
     *
     * @param strPageNum
     * @param strPageSize
     * @return
     */
    public static String msgpageQuery(String strPageNum, String strPageSize, String cname) {
        AdminDao adminDao = new AdminDao();
        //分页数据查询处理
        //计算startIndex
        int pageNum = Integer.parseInt(strPageNum);
        int pageSize = Integer.parseInt(strPageSize);
        int startIndex = (pageNum - 1) * pageSize;
        //调用dao层处理分页数据查询
        List<Message> list = adminDao.msgpageQuery(startIndex, pageSize, cname);
        //分页条计算
        int totalRecord = adminDao.msgqueryTotalRecord();
        int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        //Map 封装数据 object 存任意类型数据
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("totalPage", totalPage);
        //转为json数据类型
        String s = JSON.toJSONString(map);
        return s;
    }


    public User search(String cname) {
        User user = adminDao.queryByUsername(cname);
        return user;
    }

    /**
     * 批量删除
     * @param ids
     */
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {//防止空指针异常
            //1.遍历数组
            for (String mid : ids) {
                //2.调用dao删除
                adminDao.delete(Integer.parseInt(mid));
            }
        }
    }
}
