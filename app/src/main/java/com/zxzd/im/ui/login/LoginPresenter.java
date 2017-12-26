package com.zxzd.im.ui.login;

import com.zxzd.im.base.BasePresenter;
import com.zxzd.im.data.entity.UserBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/08 12:34
 *   desc    : 登录桥梁
 *   version :1.0
 * </pre>
 */

interface LoginPresenter extends BasePresenter{
    /**
     * 登录
     * @param mobile 手机号
     * @param password 密码
     */
    void doLogin(String mobile,String password);

    /**
     * 登录成功
     * @param bean 登录实体类
     */
    void doLoginSuccess(UserBean bean);
}
