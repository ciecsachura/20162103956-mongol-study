package com.mongolstudy.dao;

import com.mongolstudy.bean.Goods;
import com.mongolstudy.utils.C3p0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());
    public List<Goods> queryAllGoods() throws SQLException {
        String sql = "select * from goods";
        List<Goods> goodsList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Goods.class));
        return goodsList;
    }
}
