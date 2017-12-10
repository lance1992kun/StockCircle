package com.hyf.stockcircle.ui.stock;

import com.hyf.stockcircle.base.BaseView;
import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CircleDetailBean;
import com.hyf.stockcircle.data.entity.CircleListBean;
import com.hyf.stockcircle.data.entity.CollectionBean;
import com.hyf.stockcircle.data.entity.LikeBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 22:04
 *   desc    : 更新UI的接口
 *   version : 1.0
 * </pre>
 */

interface StockView extends BaseView {

    /**
     * 发布股友圈成功
     *
     * @param bean 回调实体类
     */
    void doPublishSuccess(BaseBean bean);

    /**
     * 收藏成功
     *
     * @param bean 回调实体类
     */
    void doCollectSuccess(CollectionBean bean);

    /**
     * 点赞成功
     *
     * @param bean 回调实体类
     */
    void doLikeSuccess(LikeBean bean);

    /**
     * 获取股友圈列表 成功
     *
     * @param circleListBean 回调实体类
     */
    void getCircleListSuccess(CircleListBean circleListBean);

    /**
     * 获取股友圈详情成功
     *
     * @param circleDetailBean 回调实体类
     */
    void getCircleDetailSuccess(CircleDetailBean circleDetailBean);

    /**
     * 评论成功
     *
     * @param bean 回调实体类
     */
    void doCommentSuccess(BaseBean bean);
}
