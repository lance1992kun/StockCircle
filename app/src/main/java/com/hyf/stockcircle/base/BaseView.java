package com.hyf.stockcircle.base;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : MVP - 基类View
 *     version: 1.0
 * </pre>
 */

public interface BaseView {
    /**
     * 联网失败提示信息
     *
     * @param errorMsg 错误信息
     */
    void showFailed(String errorMsg);

    /**
     * 显示联网对话框
     *
     * @param isShow 是否显示联网对话框
     */
    void showDialog(boolean isShow);
}
