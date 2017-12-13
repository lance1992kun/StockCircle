package com.hyf.stockcircle.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/12 12:01
 *   desc    : 礼物实体类
 *   version : 1.0
 * </pre>
 */

public class GiftBean {
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 唯一ID
     */
    private int id;
    /**
     * 简介
     */
    private String memo;
    /**
     * 修改日期
     */
    private long modifyDate;
    /**
     * 图片地址
     */
    private String pic;
    /**
     * 价格
     */
    private double price;
    /**
     * 标题
     */
    private String title;

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
