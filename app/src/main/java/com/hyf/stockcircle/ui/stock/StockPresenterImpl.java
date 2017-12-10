package com.hyf.stockcircle.ui.stock;

import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CircleDetailBean;
import com.hyf.stockcircle.data.entity.CircleListBean;
import com.hyf.stockcircle.data.entity.CollectionBean;
import com.hyf.stockcircle.data.entity.LikeBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 22:09
 *   desc    : 桥梁类
 *   version : 1.0
 * </pre>
 */

class StockPresenterImpl implements StockPresenter {
    /**
     * 数据操作类接口
     */
    private StockModel mStockModel = null;
    /**
     * 更新UI接口
     */
    private StockView mStockView = null;

    /**
     * 构造函数
     *
     * @param mStockView 更新UI接口
     */
    StockPresenterImpl(StockView mStockView) {
        this.mStockView = mStockView;
        mStockModel = new StockModelImpl(this);
    }

    @Override
    public void onNetFailed(String errorMsg) {
        mStockView.showDialog(false);
        mStockView.showFailed(errorMsg);
    }

    @Override
    public void doPublish(String content, String pics, String title, String token, String video) {
        mStockView.showDialog(true);
        mStockModel.doPublish(content, pics, title, token, video);
    }

    @Override
    public void doPublishSuccess(BaseBean bean) {
        mStockView.showDialog(false);
        mStockView.doPublishSuccess(bean);
    }

    @Override
    public void doCollect(int circle_id, String token) {
        mStockView.showDialog(true);
        mStockModel.doCollect(circle_id, token);
    }

    @Override
    public void doCollectSuccess(CollectionBean bean) {
        mStockView.showDialog(false);
        mStockView.doCollectSuccess(bean);
    }

    @Override
    public void doLike(int circle_id, String token) {
        mStockView.showDialog(true);
        mStockModel.doLike(circle_id, token);
    }

    @Override
    public void doLikeSuccess(LikeBean bean) {
        mStockView.showDialog(false);
        mStockView.doLikeSuccess(bean);
    }

    @Override
    public void getCircleList(int limit, int page, String token) {
        mStockView.showDialog(true);
        mStockModel.getCircleList(limit, page, token);
    }

    @Override
    public void getCircleListSuccess(CircleListBean circleListBean) {
        mStockView.showDialog(false);
        mStockView.getCircleListSuccess(circleListBean);
    }

    @Override
    public void getCircleDetail(int id, String token) {
        mStockView.showDialog(true);
        mStockModel.getCircleDetail(id, token);
    }

    @Override
    public void getCircleDetailSuccess(CircleDetailBean circleDetailBean) {
        mStockView.showDialog(false);
        mStockView.getCircleDetailSuccess(circleDetailBean);
    }

    @Override
    public void doComment(int circle_id, String content, int reply_comment_id, String token) {
        mStockView.showDialog(true);
        mStockModel.doComment(circle_id, content, reply_comment_id, token);
    }

    @Override
    public void doCommentSuccess(BaseBean bean) {
        mStockView.showDialog(false);
        mStockView.doCommentSuccess(bean);
    }
}
