package com.zxzd.im.data.entity;

import java.util.List;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/13
 *     desc   : 头条实体类
 *     version: 1.0
 * </pre>
 */

public class HeadLineBean extends BaseBean {
    /**
     * 轮播图集合
     */
    private List<HeadLineBannerBean> banners;
    /**
     * 是否可以翻页
     */
    private boolean isHasNext;
    /**
     * 资讯集合
     */
    private List<HeadLineNewsBean> newsList;
    /**
     * 公告集合
     */
    private List<HeadLineNoticeBean> notices;
    /**
     * 7*24快讯
     */
    private HeadLineWeekNewsBean weekNews;

    public List<HeadLineBannerBean> getBanners() {
        return banners;
    }

    public void setBanners(List<HeadLineBannerBean> banners) {
        this.banners = banners;
    }

    public boolean isHasNext() {
        return isHasNext;
    }

    public void setHasNext(boolean hasNext) {
        isHasNext = hasNext;
    }

    public List<HeadLineNewsBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<HeadLineNewsBean> newsList) {
        this.newsList = newsList;
    }

    public List<HeadLineNoticeBean> getNotices() {
        return notices;
    }

    public void setNotices(List<HeadLineNoticeBean> notices) {
        this.notices = notices;
    }

    public HeadLineWeekNewsBean getWeekNews() {
        return weekNews;
    }

    public void setWeekNews(HeadLineWeekNewsBean weekNews) {
        this.weekNews = weekNews;
    }
}
