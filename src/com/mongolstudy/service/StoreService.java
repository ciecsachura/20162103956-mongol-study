package com.mongolstudy.service;

import com.alibaba.fastjson.JSON;
import com.mongolstudy.bean.Store;
import com.mongolstudy.bean.Store;
import com.mongolstudy.dao.StoreDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreService {
    private StoreDao storeDao = new StoreDao();

    public String pageQuery(String strPageNum, String strPageSize) {
        //分页数据查询处理
        //计算startIndex
        int pageNum = Integer.parseInt(strPageNum);
        int pageSize = Integer.parseInt(strPageSize);
        int startIndex = (pageNum - 1)*pageSize;
        //调用dao层处理分页数据查询
        List<Store> list = storeDao.pageQuery(startIndex,pageSize);
        //分页条计算
        int totalRecord =storeDao.queryTotalRecord();
        int totalPage =totalRecord % pageSize ==0?totalRecord/pageSize:totalRecord/pageSize+1;
        //Map 封装数据 object 存任意类型数据
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("totalPage",totalPage);
        //转为json数据类型
        String s = JSON.toJSONString(map);
        return s;
    }
}
