package com.mongolstudy.dao;

import com.mongolstudy.utils.C3p0Utils;
import com.mongolstudy.utils.C3p0Utils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/7/24 15:08
 * @description: 处理收藏模块CRUD的dao
 */
public class FavoriteDao {


    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());


    /**
     * 添加收藏数据
     * @param uid
     * @param rid
     * @param date
     * @return
     */
    public int addFavorite(int uid, String rid, Date date) {

        String sql = "INSERT  INTO  tab_favorite VALUES(?,?,?)";
        int update = jdbcTemplate.update(sql, rid, date, uid);
        return  update;
    }
}
