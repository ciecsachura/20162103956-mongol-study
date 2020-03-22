package com.mongolstudy.dao;

import com.mongolstudy.bean.Route;
import com.mongolstudy.bean.RouteImg;
import com.mongolstudy.utils.C3p0Utils;
import com.mongolstudy.bean.Route;
import com.mongolstudy.bean.RouteImg;
import com.mongolstudy.utils.C3p0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/7/23 11:24
 * @description:
 */
public class RouteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());
    /**
     * 人气旅游
     * @return
     */
    public List<Route> queryOrderByCountDesc() {
        String sql = "SELECT * FROM tab_route  ORDER BY count DESC LIMIT 0,4 ";
        List<Route> routeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
        return routeList;
    }
    /**
     * 最新旅游
     * @return
     */
    public List<Route> queryOrderByRdateDesc() {
        String sql = "SELECT * FROM tab_route ORDER BY rdate DESC LIMIT 0,4 ";
        List<Route> routeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
        return routeList;
    }
    /**
     * 主题旅游
     * @return
     */
    public List<Route> queryByIsThemeTour() {
        String sql = "SELECT * FROM tab_route WHERE isThemeTour = 1 LIMIT 0,4 ";
        List<Route> routeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class));
        return routeList;
    }
    /**
     * 分页数据查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<Route> pageQuery(int startIndex, int pageSize) {
        String sql = "SELECT * FROM tab_route LIMIT ?,?";
        List<Route> routeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class), startIndex, pageSize);
        return routeList;
    }
    /**
     * 查询数据总条数
     * @return
     */
    public int queryTotalRecord() {
        String sql = "SELECT COUNT(*) FROM tab_route ";
        Integer totalRecord = jdbcTemplate.queryForObject(sql, Integer.class);//封装成int类型
        return  totalRecord;
    }
    /**
     * 根据rid查询线路详情数据
     * @param rid
     * @return
     */
    public Map<String,Object> queryDetailByRid(String rid) {
        String sql = "SELECT * FROM tab_route tbr  INNER JOIN tab_category tbc  ON tbr.cid=tbc.cid  INNER JOIN tab_seller tbs ON tbr.sid = tbs.sid  WHERE rid = ? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, rid);
        return map;
    }
    /**
     * 根据rid查询线路图片数据
     * @param rid
     * @return
     */
    public List<RouteImg> queryImgByRid(String rid) {
        String sql = "SELECT * FROM tab_route_img WHERE rid = ?";

        List<RouteImg> imgList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RouteImg.class), rid);
        return imgList;
    }
}
