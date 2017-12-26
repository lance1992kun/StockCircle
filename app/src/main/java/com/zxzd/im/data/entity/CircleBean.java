package com.zxzd.im.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 20:56
 *   desc    : 股友圈实体类
 *   version : 1.0
 * </pre>
 */

public class CircleBean extends BaseBean {
    /**
     * 评论数
     */
    private int commentCount;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 日期类型(例如：5小时前)
     */
    private String dateType;
    /**
     * 股友圈唯一ID
     */
    private int id;
    /**
     * 是否搜藏
     */
    private boolean isFavorite;
    /**
     * 是否热门
     */
    private boolean isHot;
    /**
     * 是否点赞
     */
    private boolean isLike;
    /**
     * 点赞数
     */
    private int likeCount;
    /**
     * 用户
     */
    private UserBean member;
    /**
     * 修改日期
     */
    private long modifyDate;
    /**
     * 图片列表
     */
    private String pics;
    /**
     * 标题
     */
    private String title;
    /**
     * 视频
     */
    private String video;

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
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

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
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

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
