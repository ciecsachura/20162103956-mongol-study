package com.mongolstudy.dao;

import com.mongolstudy.bean.Category;
import com.mongolstudy.utils.C3p0Utils;
import com.mongolstudy.bean.Category;
import com.mongolstudy.utils.C3p0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/7/23 9:32
 * @description: 处理类别模块业务CRUD的dao
 */
public class CategoryDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());


    /**
     * 查询所有的类别数据
     * @return
     */
    public List<Category> queryAll() {
        String sql = "SELECT * FROM tab_category ";
        List<Category> categoryList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));

        return categoryList;
    }
}
