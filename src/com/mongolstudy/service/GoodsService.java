package com.mongolstudy.service;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.Goods;
import com.mongolstudy.bean.User;
import com.mongolstudy.dao.GoodsDao;

import java.util.List;

public class GoodsService {
    static GoodsDao goodsDao = new GoodsDao();

    public static String queryAll() {
        //查询数据：调用dao层查询数据
        List<User> goodsList = goodsDao.queryAllGoods();
        //userList  ===>  JSON String
        String s = JSON.toJSONString(goodsList);
        return s;
    }
}

