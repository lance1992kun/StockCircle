package com.zxzd.im.ui.forget;

import com.zxzd.im.data.entity.BaseBean;
import com.zxzd.im.data.entity.CodeBean;
import com.zxzd.im.net.HttpRequest;
import com.zxzd.im.net.HttpUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/09 13:10
 *   desc    : 忘记密码真实操作类
 *   version :1.0
 * </pre>
 */

class ForgetModelImpl implements ForgetModel {
    /**
     * 桥梁类
     */
    private ForgetPresenter mForgetPresenter = null;

    /**
     * 构造函数
     *
     * @param mForgetPresenter 桥梁类接口
     */
    ForgetModelImpl(ForgetPresenter mForgetPresenter) {
        this.mForgetPresenter = mForgetPresenter;
    }

    @Override
    public void getCode(String mobile, String token, int type) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .getCode(mobile, token, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CodeBean>() {
                    @Override
                    public void accept(CodeBean codeBean) throws Exception {
                        mForgetPresenter.getCodeSuccess(codeBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mForgetPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }

    @Override
    public void doSubmit(String code, int code_id, String mobile, String password, String repeat_password) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .doSubmit(code, code_id, mobile, password, repeat_password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean>() {
                    @Override
                    public void accept(BaseBean baseBean) throws Exception {
                        mForgetPresenter.doSubmitSuccess(baseBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mForgetPresenter.onNetFailed(throwable.getMessage());
                    }
                });

    }
}
