package com.zxzd.im.ui.home;

import com.zxzd.im.base.BasePresenter;
import com.zxzd.im.data.entity.HeadLineBean;
import com.zxzd.im.data.entity.HeadLineLimitBean;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/11
 *     desc   : 首页头条内容桥梁类接口
 *     version: 1.0
 * </pre>
 */

interface HomePresenter extends BasePresenter {
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

    /**
     * 获取头条数据成功回调
     *
     * @param resultMsg 数据对象
     */
    void onHeadLineSuccess(HeadLineBean resultMsg);

    /**
     * 获取头条资讯翻页数据成功回调
     *
     * @param limitBean 数据对象
     */
    void onHeadLineLimitSuccess(HeadLineLimitBean limitBean);
}
