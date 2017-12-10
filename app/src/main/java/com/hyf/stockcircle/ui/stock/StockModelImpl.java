package com.hyf.stockcircle.ui.stock;

import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CircleDetailBean;
import com.hyf.stockcircle.data.entity.CircleListBean;
import com.hyf.stockcircle.data.entity.CollectionBean;
import com.hyf.stockcircle.data.entity.LikeBean;
import com.hyf.stockcircle.net.HttpRequest;
import com.hyf.stockcircle.net.HttpUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 20:36
 *   desc    : 股友圈数据操作类
 *   version :1.0
 * </pre>
 */

class StockModelImpl implements StockModel {
    /**
     * 桥梁类接口
     */
    private StockPresenter mStockPresenter = null;

    /**
     * 构造函数
     *
     * @param mStockPresenter 桥梁类接口
     */
    StockModelImpl(StockPresenter mStockPresenter) {
        this.mStockPresenter = mStockPresenter;
    }

    @Override
    public void doPublish(String content, String pics, String title, String token, String video) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .doPublish(content, pics, title, token, video)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean>() {
                    @Override
                    public void accept(BaseBean baseBean) throws Exception {
                        mStockPresenter.doPublishSuccess(baseBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mStockPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }

    @Override
    public void doCollect(int circle_id, String token) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .doCollect(circle_id, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CollectionBean>() {
                    @Override
                    public void accept(CollectionBean bean) throws Exception {
                        mStockPresenter.doCollectSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mStockPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }

    @Override
    public void doLike(int circle_id, String token) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .doLike(circle_id, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LikeBean>() {
                    @Override
                    public void accept(LikeBean bean) throws Exception {
                        mStockPresenter.doLikeSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mStockPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getCircleList(int limit, int page, String token) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .getCircleList(limit, page, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CircleListBean>() {
                    @Override
                    public void accept(CircleListBean bean) throws Exception {
                        mStockPresenter.getCircleListSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mStockPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getCircleDetail(int id, String token) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .getCircleDetail(id, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CircleDetailBean>() {
                    @Override
                    public void accept(CircleDetailBean bean) throws Exception {
                        mStockPresenter.getCircleDetailSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mStockPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }

    @Override
    public void doComment(int circle_id, String content, int reply_comment_id, String token) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .doComment(circle_id, content, reply_comment_id, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean>() {
                    @Override
                    public void accept(BaseBean bean) throws Exception {
                        mStockPresenter.doCommentSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mStockPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }
}
