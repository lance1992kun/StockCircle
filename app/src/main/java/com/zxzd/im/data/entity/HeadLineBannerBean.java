package com.zxzd.im.data.entity;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/13
 *     desc   : 轮播图实体类
 *     version: 1.0
 * </pre>
 */

public class HeadLineBannerBean {
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 唯一id
     */
    private int id;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 是否显示
     */
    private boolean isShow;
    /**
     * 修改日期
     */
    private long modifyDate;
    /**
     * 排序
     */
    private int order;
    /**
     * 跳转地址
     */
    private String returnUrl;
    /**
     * 标题
     */
    private String title;

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(int modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
