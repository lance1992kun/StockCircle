package com.zxzd.im.data.entity;

import java.util.List;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 21:10
 *   desc    : 股友圈列表实体类
 *   version : 1.0
 * </pre>
 */

public class CircleListBean {
    /**
     * 股友圈列表
     */
    private List<CircleBean> circles;
    /**
     * 是否拥有下一页
     */
    private boolean isHasNext;
    /**
     * 每页显示数量
     */
    private int limit;
    /**
     * 页码
     */
    private int page;

    public List<CircleBean> getCircles() {
        return circles;
    }

    public void setCircles(List<CircleBean> circles) {
        this.circles = circles;
    }

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
