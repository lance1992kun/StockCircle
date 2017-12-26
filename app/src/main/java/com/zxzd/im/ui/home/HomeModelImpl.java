package com.zxzd.im.ui.home;

import com.zxzd.im.data.entity.HeadLineBean;
import com.zxzd.im.data.entity.HeadLineLimitBean;
import com.zxzd.im.net.HttpRequest;
import com.zxzd.im.net.HttpUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/11
 *     desc   : 头条数据数据操作类
 *     version: 1.0
 * </pre>
 */

class HomeModelImpl implements HomeModel {
    /**
     * 头条数据桥梁类接口
     */
    private HomePresenter mHeadLinePresenter = null;

    /**
     * 构造函数
     *
     * @param mHeadLinePresenter 头条数据桥梁类接口
     */
    HomeModelImpl(HomePresenter mHeadLinePresenter) {
        this.mHeadLinePresenter = mHeadLinePresenter;
    }

    @Override
    public void getHeadLineData() {
        // 进行联网操作
        HttpUtil.getInstance().create(HttpRequest.class)
                .getIndexHot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HeadLineBean>() {
                    @Override
                    public void accept(HeadLineBean headLineBean) throws Exception {
                        // 成功回调
                        mHeadLinePresenter.onHeadLineSuccess(headLineBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // 失败回调
                        mHeadLinePresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getHeadLineLimitData(int limit, int page) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .getIndexLimit(limit, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HeadLineLimitBean>() {
                    @Override
                    public void accept(HeadLineLimitBean limitBean) throws Exception {
                        // 成功回调
                        mHeadLinePresenter.onHeadLineLimitSuccess(limitBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // 失败回调
                        mHeadLinePresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }
}
