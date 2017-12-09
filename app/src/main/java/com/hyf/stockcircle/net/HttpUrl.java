package com.hyf.stockcircle.net;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/06/09
 *     desc   : 联网地址
 *     version: 1.0
 * </pre>
 */

final class HttpUrl {
    /**
     * 联网头
     */
    static final String BASE_URL = "http://47.95.200.250";
    /**
     * 首页头条接口
     */
    static final String HOME_HEAD_LINE = "/api/index/hot.jhtml";
    /**
     * 首页头条资讯翻页
     */
    static final String HOME_HEAD_LINE_LIMIT = "/api/index/limit.jhtml";
    /**
     * 获取验证码接口
     */
    static final String MEMBER_GET_CODE = "/api/member/code.jhtml";
    /**
     * 注册接口
     */
    static final String MEMBER_REGISTER = "/api/member/register.jhtml";
    /**
     * 登录接口
     */
    static final String MEMBER_LOGIN="/api/member/login.jhtml";
}
