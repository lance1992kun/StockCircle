package com.zxzd.im.data.entity;

import java.util.List;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/26 14:13
 *   desc    : 直播实体类
 *   version : 1.0
 * </pre>
 */

public class LiveBean extends BaseBean {
    /**
     * 主播集合
     */
    private List<UserBean> anchors;
    /**
     * 广告位集合
     */
    private List<BannerBean> banners;
    /**
     * 直播间集合
     */
    private List<LiveHouse> lives;

    public List<UserBean> getAnchors() {
        return anchors;
    }

    public void setAnchors(List<UserBean> anchors) {
        this.anchors = anchors;
    }

    public List<BannerBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerBean> banners) {
        this.banners = banners;
    }

    public List<LiveHouse> getLives() {
        return lives;
    }

    public void setLives(List<LiveHouse> lives) {
        this.lives = lives;
    }
}
