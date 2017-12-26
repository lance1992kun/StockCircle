package com.zxzd.im.ui.stock;

import com.zxzd.im.base.BasePresenter;
import com.zxzd.im.data.entity.BaseBean;
import com.zxzd.im.data.entity.CircleDetailBean;
import com.zxzd.im.data.entity.CircleListBean;
import com.zxzd.im.data.entity.CollectionBean;
import com.zxzd.im.data.entity.LikeBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 20:37
 *   desc    : 股友圈桥梁类接口
 *   version :1.0
 * </pre>
 */

interface StockPresenter extends BasePresenter {
    /**
     * 发布股友圈
     *
     * @param content 内容(不能为空)
     * @param pics    图片集合(可以为空，用英文逗号','分隔)
     * @param title   标题(可以为空)
     * @param token   用户唯一标识(不能为空)
     * @param video   视频(可以为空，最多一个)
     */
    void doPublish(String content, String pics, String title, String token, String video);

    /**
     * 发布股友圈成功
     *
     * @param bean 回调实体类
     */
    void doPublishSuccess(BaseBean bean);

    /**
     * 收藏
     *
     * @param circle_id 股友圈对象id(不能为空)
     * @param token     用户唯一标识(不能为空)
     */
    void doCollect(int circle_id, String token);

    /**
     * 收藏成功
     *
     * @param bean 回调实体类
     */
    void doCollectSuccess(CollectionBean bean);

    /**
     * 点赞
     *
     * @param circle_id 股友圈对象id(不能为空)
     * @param token     用户唯一标识(不能为空)
     */
    void doLike(int circle_id, String token);

    /**
     * 点赞成功
     *
     * @param bean 回调实体类
     */
    void doLikeSuccess(LikeBean bean);

    /**
     * 获取股友圈列表
     *
     * @param limit 每页显示个数(可以为空，默认为10)
     * @param page  页码(可以为空，默认为1)
     * @param token 用户唯一标(不能为空)
     */
    void getCircleList(int limit, int page, String token);

    /**
     * 获取股友圈列表 成功
     *
     * @param circleListBean 回调实体类
     */
    void getCircleListSuccess(CircleListBean circleListBean);

    /**
     * 获取股友圈详情
     *
     * @param id    股友圈唯一ID(不能为空)
     * @param token 用户唯一标识(不能为空)
     */
    void getCircleDetail(int id, String token);

    /**
     * 获取股友圈详情成功
     *
     * @param circleDetailBean 回调实体类
     */
    void getCircleDetailSuccess(CircleDetailBean circleDetailBean);

    /**
     * 评论
     *
     * @param circle_id        股友圈对象id(不能为空)
     * @param content          评论内容(不能为空)
     * @param reply_comment_id 回复评论对象id(可以为空，回复时必传)
     * @param token            评论人（用户）唯一标识(不能为空)
     */
    void doComment(int circle_id, String content, int reply_comment_id, String token);

    /**
     * 评论成功
     *
     * @param bean 回调实体类
     */
    void doCommentSuccess(BaseBean bean);
}
