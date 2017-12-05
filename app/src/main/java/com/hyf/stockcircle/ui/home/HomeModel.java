package com.hyf.stockcircle.ui.home;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/11
 *     desc   : 头条数据操作类接口
 *     version: 1.0
 * </pre>
 */

interface HomeModel {
    /**
     * 获取头条数据
     */
    void getHeadLineData();

    /**
     * 获取头条资讯翻页数据
     *
     * @param limit 每页显示数量
     * @param page  页码
     */
    void getHeadLineLimitData(int limit, int page);
}
