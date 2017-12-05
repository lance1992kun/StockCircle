package com.hyf.stockcircle.net;

import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CodeBean;
import com.hyf.stockcircle.data.entity.HeadLineBean;
import com.hyf.stockcircle.data.entity.HeadLineLimitBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.hyf.stockcircle.net.HttpUrl.HOME_HEAD_LINE;
import static com.hyf.stockcircle.net.HttpUrl.HOME_HEAD_LINE_LIMIT;
import static com.hyf.stockcircle.net.HttpUrl.MEMBER_GET_CODE;
import static com.hyf.stockcircle.net.HttpUrl.MEMBER_REGISTER;

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
}
