package com.zxzd.im.data.entity;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/13
 *     desc   : 头条公告实体类
 *     version: 1.0
 * </pre>
 */

public class HeadLineNoticeBean {
    /**
     * 内容
     */
    private String content;
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 唯一标识
     */
    private int id;
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
     * 标题
     */
    private String title;
    /**
     * 图片地址
     */
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
