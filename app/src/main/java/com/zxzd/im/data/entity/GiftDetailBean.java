package com.zxzd.im.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/12 12:04
 *   desc    : 礼品明细实体类
 *   version : 1.0
 * </pre>
 */

public class GiftDetailBean {
    /**
     * 数量
     */
    private int count;
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 礼物
     */
    private GiftBean gift;
    /**
     * 唯一ID
     */
    private int id;
    /**
     * 用户
     */
    private UserBean member;
    /**
     * 修改日期
     */
    private long modifyDate;
    /**
     * 总金额
     */
    private int total;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public GiftBean getGift() {
        return gift;
    }

    public void setGift(GiftBean gift) {
        this.gift = gift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBean getMember() {
        return member;
    }

    public void setMember(UserBean member) {
        this.member = member;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
