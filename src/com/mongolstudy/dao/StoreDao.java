package com.mongolstudy.dao;

import com.mongolstudy.bean.Store;
import com.mongolstudy.utils.C3p0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/7/23 11:24
 * @description:
 */
public class StoreDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());


    /**
     * 分页数据查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<Store> pageQuery(int startIndex, int pageSize) {
        String sql = "SELECT * FROM tab_store LIMIT ?,?";
        List<Store> storeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Store.class), startIndex, pageSize);
        return storeList;
    }
    /**
     * 查询数据总条数
     * @return
     */
    public int queryTotalRecord() {
        String sql = "SELECT COUNT(*) FROM tab_store ";
        Integer totalRecord = jdbcTemplate.queryForObject(sql, Integer.class);//封装成int类型
        return  totalRecord;
    }

}
