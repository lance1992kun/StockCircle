package com.syk.lib.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/08/17
 *     desc   : 基类Activity实现接口
 *     version: 1.0
 * </pre>
 */

interface IBaseView {
    /**
     * 初始化数据
     *
     * @param bundle 传递过来的bundle
     */
    void initData(final Bundle bundle);

    /**
     * 绑定布局
     *
     * @return 布局Id
     */
    int bindLayout();

    /**
     * 初始化view
     *
     * @param savedInstanceState 保存的状态
     * @param view               控件
     */
    void initView(final Bundle savedInstanceState, final View view);

    /**
     * 业务操作
     *
     * @param context 上下文
     */
    void doBusiness(final Context context);

    /**
     * 视图点击事件
     *
     * @param view 视图
     */
    void onWidgetClick(final View view);
}
