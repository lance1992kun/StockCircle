package com.hyf.stockcircle.ui.home;

import com.hyf.stockcircle.data.entity.HeadLineBean;
import com.hyf.stockcircle.data.entity.HeadLineLimitBean;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/11
 *     desc   : 头条数据桥梁类
 *     version: 1.0
 * </pre>
 */

class HomePresenterImpl implements HomePresenter {
    /**
     * 头条数据操作类接口
     */
    private HomeModel mHeadLineModel = null;
    /**
     * 头条数据界面操作类接口
     */
    private HomeView mHeadLineView = null;

    /**
     * 构造函数
     *
     * @param mHeadLineView 头条数据操作类
     */
    HomePresenterImpl(HomeView mHeadLineView) {
        this.mHeadLineView = mHeadLineView;
        mHeadLineModel = new HomeModelImpl(this);
    }

    @Override
    public void getHeadLineData() {
        // 显示联网对话框
        mHeadLineView.showDialog(true);
        // 进行联网操作
        mHeadLineModel.getHeadLineData();
    }

    @Override
    public void getHeadLineLimitData(int limit, int page) {
        // 显示联网对话框
        mHeadLineView.showDialog(true);
        // 进行联网操作
        mHeadLineModel.getHeadLineLimitData(limit, page);
    }

    @Override
    public void onHeadLineSuccess(HeadLineBean resultMsg) {
        // 联网成功隐藏联网对话框
        mHeadLineView.showDialog(false);
        // 回调联网成功更新界面
        mHeadLineView.updateHeadLineView(resultMsg);
    }

    @Override
    public void onHeadLineLimitSuccess(HeadLineLimitBean limitBean) {
        // 联网成功隐藏联网对话框
        mHeadLineView.showDialog(false);
        // 回调联网成功更新界面
        mHeadLineView.updateHeadLineLimitView(limitBean);
    }

    @Override
    public void onNetFailed(String errorMsg) {
        // 联网失败隐藏联网对话框
        mHeadLineView.showDialog(false);
        // 回调联网失败更新界面
        mHeadLineView.showFailed(errorMsg);
    }
}
