package com.hyf.stockcircle.ui.register;

import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CodeBean;
import com.hyf.stockcircle.net.HttpRequest;
import com.hyf.stockcircle.net.HttpUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : 注册界面数据操作者实现对象
 *     version: 1.0
 * </pre>
 */

class RegisterModelImpl implements RegisterModel {
    /**
     * 注册界面桥梁类接口
     */
    private RegisterPresenter mRegisterPresenter = null;

    /**
     * 构造函数
     *
     * @param mRegisterPresenter 注册界面桥梁类接口
     */
    RegisterModelImpl(RegisterPresenter mRegisterPresenter) {
        this.mRegisterPresenter = mRegisterPresenter;
    }

    /**
     * 获取验证码
     *
     * @param mobile 手机号(不能为空)
     * @param token  用户唯一标识(当type=4时，token必填，其他可以为空)
     * @param type   类型(1:注册 2:找回密码 4:实名认证)
     */
    @Override
    public void getCode(String mobile, String token, int type) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .getCode(mobile, token, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CodeBean>() {
                    @Override
                    public void accept(CodeBean codeBean) throws Exception {
                        mRegisterPresenter.getCodeSuccess(codeBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mRegisterPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }

    /**
     * 执行注册操作
     *
     * @param code     验证码
     * @param code_id  验证码id
     * @param mobile   手机号
     * @param password 密码
     * @param invite   邀请码(可以为空)
     */
    @Override
    public void doRegister(String code, int code_id, String mobile, String password, String invite) {
        HttpUtil.getInstance().create(HttpRequest.class)
                .doRegister(code, code_id, mobile, password, invite)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean>() {
                    @Override
                    public void accept(BaseBean baseBean) throws Exception {
                        mRegisterPresenter.doRegisterSuccess(baseBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mRegisterPresenter.onNetFailed(throwable.getMessage());
                    }
                });
    }
}
