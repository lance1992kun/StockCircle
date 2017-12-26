package com.zxzd.im.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/26 14:21
 *   desc    : 直播间实体类
 *   version : 1.0
 * </pre>
 */

public class LiveHouse {
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 唯一ID
     */
    private int id;
    /**
     * 是否显示在首页
     */
    private boolean isIndex;
    /**
     * 修改日期
     */
    private long modifyDate;
    /**
     * 直播间名称
     */
    private String name;
    /**
     * 直播间编号
     */
    private String no;
    /**
     * 排序
     */
    private int order;
    /**
     * 状态
     */
    private String status;

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

    public boolean isIndex() {
        return isIndex;
    }

    public void setIndex(boolean index) {
        isIndex = index;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
