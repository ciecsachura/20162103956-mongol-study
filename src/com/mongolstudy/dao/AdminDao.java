package com.mongolstudy.dao;
import com.mongolstudy.bean.Message;
import com.mongolstudy.bean.User;
import com.mongolstudy.utils.C3p0Utils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
public class AdminDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());
    /**
     * 查询所有数据
     *
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
     * 分页数据查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<User> pageQuery(int startIndex, int pageSize,String cname) {
        String sql = "";
        List<User> userList = new ArrayList<>();
        if (cname != null && !cname.equals("")){
             sql = "SELECT * FROM tab_user WHERE username LIKE CONCAT('%',?,'%') OR telephone = ? LIMIT ?,?";
             userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class),cname,cname, startIndex, pageSize);
        }else {
             sql = "SELECT * FROM tab_user LIMIT ?,?";
             userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), startIndex, pageSize);
        }
        return userList;
    }
    /**
     * 分页数据查询 feedback
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<Message> msgpageQuery(int startIndex, int pageSize, String cname) {
        String sql = "";
        List<Message> msgList = new ArrayList<>();
        if (cname != null && !cname.equals("")){
            sql = "SELECT * FROM messagebox WHERE title LIKE CONCAT('%',?,'%') OR telephone = ? LIMIT ?,?";
            msgList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Message.class),cname,cname, startIndex, pageSize);
        }else {
            sql = "SELECT * FROM messagebox LIMIT ?,?";
            msgList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Message.class), startIndex, pageSize);
        }
        return msgList;
    }
    /**
     * 查询数据总条数
     * @return
     */
    public int queryTotalRecord() {
        String sql = "SELECT COUNT(*) FROM tab_user ";
        Integer totalRecord = jdbcTemplate.queryForObject(sql, Integer.class);//封装成int类型

        return  totalRecord;
    }
    /**
     * 查询数据总条数
     * @return
     */
    public int msgqueryTotalRecord() {
        String sql = "SELECT COUNT(*) FROM messagebox ";
        Integer totalRecord = jdbcTemplate.queryForObject(sql, Integer.class);//封装成int类型

        return  totalRecord;
    }
    /**
     * 删除数据
     * @param
     * @return
     */
  /*  public List<User> deleteUser(User user){
        String sql="DELETE * FROM tab_user WHERE uid=? ";
        int delete = jdbcTemplate.update(sql,
                user.getUid()
        );

        return null;
    }*/

    /**
     * 添加数据
     * @param user
     * @return
     */
    public int addUser(User user) {
        //写SQL：
        String sql = "INSERT INTO tab_user (username,password,telephone,grade,admin,status,code) VALUES(?,?,?,?,?,?,?)";
        //执行SQL：
        int update = jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getTelephone(),
                user.getGrade(),
                user.getAdmin(),
                user.getStatus(),
                user.getCode()
        );
        return update;
    }

    /**
     * 改   回显数据   修改数据
     * @param
     * @return
     */

    public User queryById(int uid){
        User user = new User();
        String sql ="SELECT * FROM tab_user WHERE uid=? ";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),uid);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }


    /**
     * 删
     * @param uid
     * @return
     */
    public int deleteUser(int uid) {
        String sql="DELETE FROM tab_user WHERE uid=? ";
        return jdbcTemplate.update(sql,
                uid
        );
    }

    public int updateUser(User user) {
        String sql = "update tab_user set username =?, password= ?,admin =? ,grade =? ,telephone = ? where uid = ?";
        int update = jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getAdmin(),
                user.getGrade(),
                user.getTelephone(),
                user.getUid()
        );
        return update;
    }

    public User queryByUsername(String cname) {
        String sql="SELECT * FROM tab_user WHERE username=? or telephone= ?";
        User user = new User();
        try {
            user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),cname,cname);
            return user;
        } catch (DataAccessException e) {
            return  null;
        }
    }

    public int delete(int mid) {
        String sql="DELETE FROM messagebox WHERE mid=? ";
        return jdbcTemplate.update(sql,mid
        );
    }
}
