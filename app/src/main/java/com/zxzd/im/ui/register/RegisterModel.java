package com.zxzd.im.ui.register;

import io.reactivex.annotations.Nullable;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : 注册界面数据操作层
 *     version: 1.0
 * </pre>
 */

interface RegisterModel {
    /**
     * 获取验证码
     *
     * @param mobile 手机号(不能为空)
     * @param token  用户唯一标识(当type=4时，token必填，其他可以为空)
     * @param type   类型(1:注册 2:找回密码 4:实名认证)
     */
    void getCode(String mobile, String token, int type);

    /**
     * 执行注册操作
     *
     * @param code     验证码
     * @param code_id  验证码id
     * @param mobile   手机号
     * @param password 密码
     * @param invite   邀请码(可以为空)
     */
    void doRegister(String code, int code_id, String mobile, String password, @Nullable String invite);
}
