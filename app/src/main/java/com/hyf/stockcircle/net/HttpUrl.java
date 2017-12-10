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
    static final String MEMBER_LOGIN = "/api/member/login.jhtml";
    /**
     * 忘记密码接口
     */
    static final String MEMBER_FORGET = "/api/member/forget.jhtml";
    /**
     * 发布股友圈
     */
    static final String CIRCLE_PUBLISH = "/api/circle/publish.jhtml";
    /**
     * 收藏
     */
    static final String CIRCLE_COLLECT = "";
    /**
     * 点赞
     */
    static final String CIRCLE_LIKE = "/api/circle/like.jhtml";
    /**
     * 获取朋友圈列表
     */
    static final String CIRCLE_LIST = "/api/circle/list.jhtml";
    /**
     * 获取朋友圈详情
     */
    static final String CIRCLE_DETAIL = "/api/circle/detail.jhtml";
    /**
     * 评论
     */
    static final String CIRCLE_COMMENT="/api/circle/comment.jhtml";
}
