package com.zxzd.im.ui.login;

import com.zxzd.im.data.entity.UserBean;
import com.zxzd.im.net.HttpRequest;
import com.zxzd.im.net.HttpUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/08 12:32
 *   desc    : 执行登录的操作类
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
        HttpUtil.getInstance().create(HttpRequest.class)
                .doLogin(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean bean) throws Exception {
                        mLoginPresenter.doLoginSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mLoginPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }
}
