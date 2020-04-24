package com.mongolstudy.dao;

import com.mongolstudy.bean.Goods;
import com.mongolstudy.bean.User;
import com.mongolstudy.utils.C3p0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());
    public List<User> queryAllGoods(){
        String sql = "SELECT * FROM tab_user";
        List<User> goodsList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        return goodsList;
    }
}
