package com.mongolstudy.service;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.Category;
import com.mongolstudy.dao.CategoryDao;


import java.util.List;

/**
 * 处理商品类别 service层
 */
public class CategoryService {


    /**
     * 查询所有商品类别数据
     * @return
     */
    public String queryAll() {
        // 调用dao层所有商品类别数据
        CategoryDao categoryDao = new CategoryDao();
        //
        List<Category> categoryList = categoryDao.queryAll();
        //数据转换 category
        String s = JSON.toJSONString(categoryList);


        return s;
    }
}
