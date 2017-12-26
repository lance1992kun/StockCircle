package com.zxzd.im.data.entity;

import java.util.List;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/12 12:16
 *   desc    : 礼物列表实体类
 *   version : 1.0
 * </pre>
 */

public class GiftListBean extends BaseBean {
    /**
     * 礼物集合
     */
    private List<GiftBean> gifts;
    /**
     * 每页显示个数
     */
    private int limit;
    /**
     * 页码
     */
    private int page;
    /**
     * 总数
     */
    private int total;

    public List<GiftBean> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftBean> gifts) {
        this.gifts = gifts;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 总页数

     */
    private int totalPages;
}
