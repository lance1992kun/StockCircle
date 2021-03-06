package com.zxzd.im.net;

import com.zxzd.im.data.entity.BaseBean;
import com.zxzd.im.data.entity.CircleDetailBean;
import com.zxzd.im.data.entity.CircleListBean;
import com.zxzd.im.data.entity.CodeBean;
import com.zxzd.im.data.entity.CollectionBean;
import com.zxzd.im.data.entity.GiftListBean;
import com.zxzd.im.data.entity.GiftSendBean;
import com.zxzd.im.data.entity.HeadLineBean;
import com.zxzd.im.data.entity.HeadLineLimitBean;
import com.zxzd.im.data.entity.LikeBean;
import com.zxzd.im.data.entity.LiveBean;
import com.zxzd.im.data.entity.ProductDetailBean;
import com.zxzd.im.data.entity.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.zxzd.im.net.HttpUrl.CIRCLE_COLLECT;
import static com.zxzd.im.net.HttpUrl.CIRCLE_COMMENT;
import static com.zxzd.im.net.HttpUrl.CIRCLE_DETAIL;
import static com.zxzd.im.net.HttpUrl.CIRCLE_LIKE;
import static com.zxzd.im.net.HttpUrl.CIRCLE_LIST;
import static com.zxzd.im.net.HttpUrl.CIRCLE_PUBLISH;
import static com.zxzd.im.net.HttpUrl.GIFT_LIST;
import static com.zxzd.im.net.HttpUrl.GIFT_SEND;
import static com.zxzd.im.net.HttpUrl.HOME_HEAD_LINE;
import static com.zxzd.im.net.HttpUrl.HOME_HEAD_LINE_LIMIT;
import static com.zxzd.im.net.HttpUrl.HOME_LIVE;
import static com.zxzd.im.net.HttpUrl.MEMBER_FORGET;
import static com.zxzd.im.net.HttpUrl.MEMBER_GET_CODE;
import static com.zxzd.im.net.HttpUrl.MEMBER_LOGIN;
import static com.zxzd.im.net.HttpUrl.MEMBER_REGISTER;
import static com.zxzd.im.net.HttpUrl.PRODUCT_DETAIL;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/08/17
 *     desc   : 联网接口
 *     version: 1.0
 * </pre>
 */

public interface HttpRequest {
    /**
     * 首页头条
     *
     * @return 首页头条数据
     */
    @POST(HOME_HEAD_LINE)
    Observable<HeadLineBean> getIndexHot();

    /**
     * 首页头条资讯翻页
     *
     * @param limit 每页显示数量
     * @param page  页码
     * @return 首页头条资讯翻页
     */
    @POST(HOME_HEAD_LINE_LIMIT)
    @FormUrlEncoded
    Observable<HeadLineLimitBean> getIndexLimit(@Field("int") int limit, @Field("page") int page);

    /**
     * 获取直播信息
     *
     * @return 直播信息
     */
    @POST(HOME_LIVE)
    Observable<LiveBean> getLive();

    /**
     * 获取验证码
     *
     * @param mobile 手机号(不能为空)
     * @param token  用户唯一标识(当type=4时，token必填，其他可以为空)
     * @param type   类型(1:注册 2:找回密码 4:实名认证)
     * @return 验证码
     */
    @POST(MEMBER_GET_CODE)
    @FormUrlEncoded
    Observable<CodeBean> getCode(@Field("mobile") String mobile, @Field("token") String token, @Field("type") int type);

    /**
     * 执行注册操作
     *
     * @param code     验证码
     * @param code_id  验证码id
     * @param mobile   手机号
     * @param password 密码
     * @param invite   邀请码(可以为空)
     * @return 注册操作结果
     */
    @POST(MEMBER_REGISTER)
    @FormUrlEncoded
    Observable<BaseBean> doRegister(@Field("code") String code, @Field("code_id") int code_id, @Field("mobile") String mobile,
                                    @Field("password") String password, @Field("invite") String invite);

    /**
     * 执行登录操作
     *
     * @param mobile   手机号
     * @param password 密码
     * @return 登录结果
     */
    @POST(MEMBER_LOGIN)
    @FormUrlEncoded
    Observable<UserBean> doLogin(@Field("mobile") String mobile, @Field("password") String password);

    /**
     * 执行忘记密码操作
     *
     * @param code            验证码
     * @param code_id         验证码id
     * @param mobile          手机号
     * @param password        密码
     * @param repeat_password 重复密码
     * @return 忘记密码操作结果
     */
    @POST(MEMBER_FORGET)
    @FormUrlEncoded
    Observable<BaseBean> doSubmit(@Field("code") String code, @Field("code_id") int code_id, @Field("mobile") String mobile,
                                  @Field("password") String password, @Field("repeat_password") String repeat_password);

    /**
     * 发布朋友圈
     *
     * @param content 内容(不能为空)
     * @param pics    图片集合(可以为空，用英文逗号','分隔)
     * @param title   标题(可以为空)
     * @param token   用户唯一标识(不能为空)
     * @param video   视频(可以为空，最多一个)
     * @return 发布朋友圈回调对象
     */
    @POST(CIRCLE_PUBLISH)
    @FormUrlEncoded
    Observable<BaseBean> doPublish(@Field("content") String content, @Field("pics") String pics, @Field("title") String title,
                                   @Field("token") String token, @Field("video") String video);

    /**
     * 收藏
     *
     * @param circle_id 股友圈id
     * @param token     用户唯一标识
     * @return 收藏回调对象
     */
    @POST(CIRCLE_COLLECT)
    @FormUrlEncoded
    Observable<CollectionBean> doCollect(@Field("circle_id") int circle_id, @Field("token") String token);

    /**
     * 点赞
     *
     * @param circle_id 股友圈id
     * @param token     用户唯一标识
     * @return 点赞回调对象
     */
    @POST(CIRCLE_LIKE)
    @FormUrlEncoded
    Observable<LikeBean> doLike(@Field("circle_id") int circle_id, @Field("token") String token);

    /**
     * 获取股友圈列表
     *
     * @param limit 每页显示个数(可以为空，默认为10)
     * @param page  页码(可以为空，默认为1)
     * @param token 用户唯一标(不能为空)
     * @return 列表对象
     */
    @POST(CIRCLE_LIST)
    @FormUrlEncoded
    Observable<CircleListBean> getCircleList(@Field("limit") int limit, @Field("page") int page,
                                             @Field("token") String token);

    /**
     * 获取股友圈详情
     *
     * @param id    股友圈唯一ID(不能为空)
     * @param token 用户唯一标识(不能为空)
     * @return 详情对象
     */
    @POST(CIRCLE_DETAIL)
    @FormUrlEncoded
    Observable<CircleDetailBean> getCircleDetail(@Field("id") int id, @Field("token") String token);

    /**
     * 评论
     *
     * @param circle_id        股友圈对象id(不能为空)
     * @param content          评论内容(不能为空)
     * @param reply_comment_id 回复评论对象id(可以为空，回复时必传)
     * @param token            评论人（用户）唯一标识(不能为空)
     * @return 评论对象
     */
    @POST(CIRCLE_COMMENT)
    @FormUrlEncoded
    Observable<BaseBean> doComment(@Field("circle_id") int circle_id, @Field("content") String content,
                                   @Field("reply_comment_id") int reply_comment_id, @Field("token") String token);

    /**
     * 发送礼物
     *
     * @param count          数量(可以为空，默认为1)
     * @param gift_id        礼物ID(不能为空)
     * @param send_member_id 赠送主播用户id(不能为空)
     * @param token          用户唯一标识(不能为空)
     * @return 发送礼物实体类
     */
    @POST(GIFT_SEND)
    @FormUrlEncoded
    Observable<GiftSendBean> sendGift(@Field("count") int count, @Field("gift_id") int gift_id,
                                      @Field("send_member_id") int send_member_id, @Field("token") String token);

    /**
     * 获取礼物列表
     *
     * @param limit 每页显示个数
     * @param page  页码
     * @return 礼物列表实体
     */
    @POST(GIFT_LIST)
    @FormUrlEncoded
    Observable<GiftListBean> getGiftList(@Field("limit") int limit, @Field("page") int page);

    /**
     * 获取商品详情
     *
     * @param product_id 商品id
     * @param token      用户唯一标识
     * @return 商品详情实体类
     */
    @POST(PRODUCT_DETAIL)
    @FormUrlEncoded
    Observable<ProductDetailBean> getProductDetail(@Field("product_id") int product_id, @Field("token") String token);
}
