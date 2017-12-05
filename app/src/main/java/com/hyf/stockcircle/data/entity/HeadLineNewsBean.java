package com.hyf.stockcircle.data.entity;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/13
 *     desc   : 头条资讯实体类
 *     version: 1.0
 * </pre>
 */

public class HeadLineNewsBean {
    /**
     * 点击量
     */
    private int clickNum;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private long createDate;
    /**
     * 摘要
     */
    private String digest;
    /**
     * 唯一ID
     */
    private int id;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 是否精选
     */
    private boolean isHot;
    /**
     * 是否显示在首页
     */
    private boolean isShowIndex;
    /**
     * 修改时间
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

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

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

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isShowIndex() {
        return isShowIndex;
    }

    public void setShowIndex(boolean showIndex) {
        isShowIndex = showIndex;
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
}
