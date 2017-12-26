package com.zxzd.im.data.entity;

import java.util.List;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/14
 *     desc   : 首页头条资讯翻页实体类
 *     version: 1.0
 * </pre>
 */

public class HeadLineLimitBean extends BaseBean {
    /**
     * 是否可以翻页
     */
    private boolean isHasNext;
    /**
     * 每页显示个数
     */
    private int limit;
    /**
     * 资讯列表
     */
    private List<HeadLineNewsBean> news_list;
    /**
     * 页码
     */
    private int page;

    public boolean isHasNext() {
        return isHasNext;
    }

    public void setHasNext(boolean hasNext) {
        isHasNext = hasNext;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<HeadLineNewsBean> getNews_list() {
        return news_list;
    }

    public void setNews_list(List<HeadLineNewsBean> news_list) {
        this.news_list = news_list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
