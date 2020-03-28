package com.mongolstudy.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 商品实体类
 */
public class Store implements Serializable {

    private int sid;//线路id，必输
    private String sname;//线路名称，必输
    private double price;//价格，必输
    private String storeIntroduce;//线路介绍
    private String sflag;   //是否上架，必输，0代表没有上架，1代表是上架
    private String sdate;   //上架时间
    private int count;//收藏数量
    private int cid;//所属分类，必输
    private String simage;//缩略图
    private String sourceId;//抓取数据的来源id
    /**
     * 无参构造方法
     */
    public Store(){}

    /**
     * 有参构造方法
     * @param sid
     * @param sname
     * @param price
     * @param storeIntroduce
     * @param sflag
     * @param sdate
     * @param count
     * @param cid
     * @param simage
     * @param sid
     * @param sourceId
     */
    public Store(int sid, String sname, double price, String storeIntroduce, String sflag, String sdate,  int count, int cid, String simage,String sourceId) {
        this.sid = sid;
        this.sname = sname;
        this.price = price;
        this.storeIntroduce = storeIntroduce;
        this.sflag = sflag;
        this.sdate = sdate;
        this.count = count;
        this.cid = cid;
        this.simage = simage;
        this.sid = sid;
        this.sourceId = sourceId;
    }

   /* public List<StoreImg> getRouteImgList() {
        return storeImgList;
    }

    public void setStoreImgList(List<StoreImg> storeImgList) {
        this.storeImgList = storeImgList;
    }*/

    /*public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }*/

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public int getSid() {
        return sid;
    }

    public void setRid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setRname(String sname) {
        this.sname = sname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStoreIntroduce() {
        return storeIntroduce;
    }

    public void setStoreIntroduce(String storeIntroduce) {
        this.storeIntroduce = storeIntroduce;
    }

    public String getSflag() {
        return sflag;
    }

    public void setRflag(String sflag) {
        this.sflag = sflag;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

}
