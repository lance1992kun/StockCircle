package com.hyf.stockcircle.ui.login;

import com.hyf.stockcircle.base.BasePresenter;
import com.hyf.stockcircle.data.entity.LoginBean;

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
    void doLoginSuccess(LoginBean bean);
}
