package com.mongolstudy.utils;

import com.mongolstudy.bean.Goods;
import com.mongolstudy.dao.GoodsDao;

import java.sql.SQLException;

public class text {
    public static void main(String[] args) {
        GoodsDao goodsDao = new GoodsDao();
        try {
            for (Goods goods :
                    goodsDao.queryAllGoods()) {
                System.out.println(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
