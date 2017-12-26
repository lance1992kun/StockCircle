package com.zxzd.im.ui.login;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/08 12:27
 *   desc    : 登录操作
 *   version :1.0
 * </pre>
 */

interface LoginModel {
    /**
     * 登录
     * @param mobile 手机号
     * @param password 密码
     */
    void doLogin(String mobile,String password);
}
