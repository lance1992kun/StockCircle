package com.hyf.stockcircle.base;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : MVP - 基类Presenter
 *     version: 1.0
 * </pre>
 */

public interface BasePresenter {
    /**
     * 获取网络数据失败回调
     *
     * @param errorMsg 失败信息
     */
    void onNetFailed(String errorMsg);
}
