package com.hyf.stockcircle.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 21:15
 *   desc    : 股友圈详情实体类
 *   version : 1.0
 * </pre>
 */

public class CircleDetailBean extends BaseBean {
    /**
     * 股友圈
     */
    private CircleBean circle;

    public CircleBean getCircle() {
        return circle;
    }

    public void setCircle(CircleBean circle) {
        this.circle = circle;
    }
}
