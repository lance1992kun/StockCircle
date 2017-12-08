package com.hyf.stockcircle.ui.login;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/08 12:32
 *   desc    :
 *   version :1.0
 * </pre>
 */

class LoginModelImpl implements LoginModel {
    /**
     * 桥梁类
     */
    private LoginPresenter mLoginPresenter = null;

    /**
     * 构造函数
     *
     * @param mLoginPresenter 桥梁类
     */
    LoginModelImpl(LoginPresenter mLoginPresenter) {
        this.mLoginPresenter = mLoginPresenter;
    }

    /**
     * 登录
     *
     * @param mobile   手机号
     * @param password 密码
     */
    @Override
    public void doLogin(String mobile, String password) {
        mLoginPresenter.doLogin(mobile, password);
    }
}
