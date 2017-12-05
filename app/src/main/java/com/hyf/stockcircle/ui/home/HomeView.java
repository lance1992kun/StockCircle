package com.hyf.stockcircle.ui.home;

import com.hyf.stockcircle.base.BaseView;
import com.hyf.stockcircle.data.entity.HeadLineBean;
import com.hyf.stockcircle.data.entity.HeadLineLimitBean;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/11
 *     desc   : 头条数据界面操作类接口
 *     version: 1.0
 * </pre>
 */

interface HomeView extends BaseView {
    /**
     * 联网成功更新头条界面
     *
     * @param resultMsg 数据模型
     */
    void updateHeadLineView(HeadLineBean resultMsg);

    /**
     * 联网成功更新头条界面
     *
     * @param limitBean 数据模型
     */
    void updateHeadLineLimitView(HeadLineLimitBean limitBean);
}
