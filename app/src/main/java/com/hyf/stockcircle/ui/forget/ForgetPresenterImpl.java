package com.hyf.stockcircle.ui.forget;

import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CodeBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/09 13:20
 *   desc    : 桥梁实现类
 *   version :1.0
 * </pre>
 */

class ForgetPresenterImpl implements ForgetPresenter {
    /**
     * GUI接口
     */
    private ForgetView mForgetView = null;
    /**
     * 数据操作类
     */
    private ForgetModel mForgetModel = null;

    /**
     * 构造函数
     *
     * @param mForgetView GUI接口
     */
    ForgetPresenterImpl(ForgetView mForgetView) {
        this.mForgetView = mForgetView;
        mForgetModel = new ForgetModelImpl(this);
    }

    @Override
    public void onNetFailed(String errorMsg) {
        mForgetView.showDialog(false);
        mForgetView.showFailed(errorMsg);
    }

    @Override
    public void getCode(String mobile, String token, int type) {
        mForgetView.onGetCode();
        mForgetView.showDialog(true);
        mForgetModel.getCode(mobile, token, type);
    }

    @Override
    public void getCodeSuccess(CodeBean codeBean) {
        mForgetView.showDialog(false);
        mForgetView.getCodeSuccess(codeBean);
    }

    @Override
    public void doSubmit(String code, int code_id, String mobile, String password, String repeat_password) {
        mForgetView.showDialog(true);
        mForgetModel.doSubmit(code, code_id, mobile, password, repeat_password);
    }

    @Override
    public void doSubmitSuccess(BaseBean baseBean) {
        mForgetView.showDialog(false);
        mForgetView.doSubmitSuccess(baseBean);
    }
}
