package com.zxzd.im.ui.login;

import com.zxzd.im.data.entity.UserBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/08 12:38
 *   desc    : 登录桥梁类实现
 *   version :1.0
 * </pre>
 */

class LoginPresenterImpl implements LoginPresenter {
    /**
     * 登录操作类
     */
    private LoginModel mLoginModel = null;
    /**
     * 登录图像更新类
     */
    private LoginView mLoginView = null;

    /**
     * 构造函数
     *
     * @param mLoginView View回调
     */
    LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginModel = new LoginModelImpl(this);
    }

    @Override
    public void doLogin(String mobile, String password) {
        mLoginView.showDialog(true);
        mLoginModel.doLogin(mobile, password);
    }

    @Override
    public void doLoginSuccess(UserBean bean) {
        mLoginView.showDialog(false);
        mLoginView.doLoginSuccess(bean);
    }

    @Override
    public void onNetFailed(String errorMsg) {
        mLoginView.showFailed(errorMsg);
        mLoginView.showDialog(false);
    }
}
