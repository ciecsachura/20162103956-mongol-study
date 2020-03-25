package com.mongolstudy.dao;

import com.mongolstudy.bean.User;
import com.mongolstudy.utils.C3p0Utils;
import com.mongolstudy.utils.UuidUtil;
import com.mongolstudy.utils.C3p0Utils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;

import java.util.List;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/7/22 9:31
 * @description: 从数据库中查询数据
 */
public class UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());
    /**
     * 查询所有数据
     * @return
     */
    public List<User> queryAll() {
        //1、初始化JdbcTemplate模板：创建JdbcTemplate对象
        //2、写sql
        String sql = "SELECT * FROM tab_user";
        //3、执行sql，返回值 List-集合
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
    /**
     * 添加数据
     * @param user
     * @return
     */
    public int addUser(User user) {
        //写SQL：
        String sql = "INSERT INTO tab_user (username,password,telephone,admin,code) VALUES(?,?,?,?,?)";
        //执行SQL：
        int update = jdbcTemplate.update(sql,
                                        user.getUsername(),
                                        user.getPassword(),
                                        user.getTelephone(),
                                        user.getAdmin(),
                                        user.getCode()
                                        );

        return update;
    }

    /**
     * 根据username和password查询数据
     * @param username
     * @param password
     * @return
     */
    public User queryByUsernameAndPassword(String username, String password) {
        //1、书写sql
        String sql = "SELECT * FROM tab_user WHERE username=? AND password=?";
        //2、执行sql :处理异常  Ctrl+Alt+T
        try {
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            return  null;
        }
    }
}

