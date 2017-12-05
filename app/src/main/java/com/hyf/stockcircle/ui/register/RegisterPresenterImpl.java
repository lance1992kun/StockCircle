package com.hyf.stockcircle.ui.register;

import android.support.annotation.Nullable;

import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CodeBean;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : 注册界面内容提供者
 *     version: 1.0
 * </pre>
 */

class RegisterPresenterImpl implements RegisterPresenter {
    /**
     * 注册界面数据操作类
     */
    private RegisterModel mRegisterModel = null;
    /**
     * 注册界面View层回调
     */
    private RegisterView mRegisterView = null;

    /**
     * 构造函数
     *
     * @param mRegisterView View操作对象
     */
    RegisterPresenterImpl(RegisterView mRegisterView) {
        this.mRegisterView = mRegisterView;
        mRegisterModel = new RegisterModelImpl(this);
    }

    @Override
    public void onNetFailed(String errorMsg) {
        mRegisterView.showDialog(false);
        mRegisterView.showFailed(errorMsg);
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
        mRegisterView.showDialog(true);
        mRegisterView.onGetCode();
        mRegisterModel.getCode(mobile, token, type);
    }

    /**
     * 获取验证码成功
     *
     * @param codeBean 验证码实体类
     */
    @Override
    public void getCodeSuccess(CodeBean codeBean) {
        mRegisterView.showDialog(false);
        mRegisterView.getCodeSuccess(codeBean);
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
    public void doRegister(String code, int code_id, String mobile, String password, @Nullable String invite) {
        mRegisterView.showDialog(true);
        mRegisterModel.doRegister(code, code_id, mobile, password, invite);
    }

    /**
     * 注册成功跳转界面
     *
     * @param baseBean 回调实体类
     */
    @Override
    public void doRegisterSuccess(BaseBean baseBean) {
        mRegisterView.showDialog(false);
        mRegisterView.doRegisterSuccess(baseBean);
    }
}
