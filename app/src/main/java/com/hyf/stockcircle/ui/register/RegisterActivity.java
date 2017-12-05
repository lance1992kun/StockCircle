package com.hyf.stockcircle.ui.register;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.EmptyUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hyf.stockcircle.R;
import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CodeBean;
import com.hyf.stockcircle.util.DialogUtil;
import com.syk.lib.AppConfig;
import com.syk.lib.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : 注册界面
 *     version: 1.0
 * </pre>
 */

public class RegisterActivity extends BaseActivity implements RegisterView {
    /**
     * 注册界面桥梁类
     */
    private RegisterPresenterImpl mRegisterPresenter = null;
    /**
     * 验证码计时器
     */
    private Disposable mCodeTimer = null;
    /**
     * 获取验证码按钮
     */
    private Button mCodeBtn = null;
    /**
     * 手机号编辑框
     */
    private EditText mPhoneEdit = null;
    /**
     * 验证码编辑框
     */
    private EditText mCodeEdit = null;
    /**
     * 密码编辑框
     */
    private EditText mPasswordEdit = null;
    /**
     * 邀请码编辑框(可为空)
     */
    private EditText mInviteEdit = null;
    /**
     * 验证码ID保存
     */
    private int codeId = 0;
    /**
     * 手机号码保存字符串
     */
    private String phoneNumber = null;
    /**
     * 验证码保存字符串
     */
    private String codeNumber = null;
    /**
     * 密码保存字符串
     */
    private String passwordString = null;
    /**
     * 邀请码保存字符串
     */
    private String inviteString = null;

    @Override
    protected void onDestroy() {
        if (mCodeTimer != null && !mCodeTimer.isDisposed()) {
            mCodeTimer.dispose();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void initData(Bundle bundle) {
        mRegisterPresenter = new RegisterPresenterImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        // 获取验证码按钮
        mCodeBtn = F(R.id.mCodeBtn);
        // 手机号码编辑框
        mPhoneEdit = F(R.id.mPhoneEdit);
        // 验证码编辑框
        mCodeEdit = F(R.id.mCodeEdit);
        // 密码编辑框
        mPasswordEdit = F(R.id.mPasswordEdit);
        // 邀请码编辑框(可以为空)
        mInviteEdit = F(R.id.mInviteEdit);
        // 监听事件
        setOnClick(mCodeBtn);
        setOnClick(F(R.id.mCloseBtn));
        setOnClick(F(R.id.mRegisterBtn));
    }

    @Override
    public void doBusiness(Context context) {

    }

    /**
     * 验证数据
     */
    private boolean verifyData() {
        boolean isVerified = true;
        phoneNumber = mPhoneEdit.getText().toString().trim();
        codeNumber = mCodeEdit.getText().toString().trim();
        passwordString = mPasswordEdit.getText().toString().trim();
        inviteString = mInviteEdit.getText().toString().trim();
        if (!RegexUtils.isMobileExact(phoneNumber)) {
            ToastUtils.showShort("请输入正确的手机号");
            isVerified = false;
        }
        if (EmptyUtils.isEmpty(codeNumber)) {
            ToastUtils.showShort("请输入正确的验证码");
            isVerified = false;
        }
        if (passwordString.length() < 6) {
            ToastUtils.showShort("请输入6位以上的密码");
            isVerified = false;
        }
        return isVerified;
    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            // 获取验证码按钮
            case R.id.mCodeBtn:
                phoneNumber = mPhoneEdit.getText().toString();
                if (!RegexUtils.isMobileExact(phoneNumber)) {
                    ToastUtils.showShort("请输入正确的手机号");
                    return;
                } else {
                    mRegisterPresenter.getCode(phoneNumber, "", 1);
                }
                break;
            // 关闭按钮
            case R.id.mCloseBtn:
                this.finish();
                break;
            // 注册按钮
            case R.id.mRegisterBtn:
                if (verifyData()) {
                    if (EmptyUtils.isEmpty(inviteString)) {
                        mRegisterPresenter.doRegister(codeNumber, codeId, phoneNumber, passwordString, null);
                    } else {
                        mRegisterPresenter.doRegister(codeNumber, codeId, phoneNumber, passwordString, inviteString);
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 联网失败
     *
     * @param errorMsg 错误信息
     */
    @Override
    public void showFailed(String errorMsg) {
        LogUtils.e(errorMsg);
    }

    /**
     * 显示联网对话框
     *
     * @param isShow 是否显示联网对话框
     */
    @Override
    public void showDialog(boolean isShow) {
        if (isShow) {
            DialogUtil.getInstance().showNetDialog(this, "正在获取…");
        } else {
            DialogUtil.getInstance().hideNetDialog();
        }
    }

    /**
     * 点击获取验证码之后
     */
    @Override
    public void onGetCode() {
        // 禁止按钮的点击
        mCodeBtn.setEnabled(false);
        if (mCodeTimer != null && !mCodeTimer.isDisposed()) {
            mCodeTimer.dispose();
        }
        mCodeTimer = Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (aLong == 60) {
                            mCodeBtn.setEnabled(true);
                            mCodeBtn.setText(getResources().getText(R.string.get_code_hint));
                            mCodeTimer.dispose();
                        } else {
                            int remain = (int) (60 - aLong);
                            String remainString = remain + "秒后从发";
                            mCodeBtn.setText(remainString);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    /**
     * 获取验证码成功
     *
     * @param codeBean 验证码实体类
     */
    @Override
    public void getCodeSuccess(CodeBean codeBean) {
        codeId = codeBean.getCodeId();
    }

    /**
     * 注册成功
     *
     * @param baseBean 回调实体类
     */
    @Override
    public void doRegisterSuccess(BaseBean baseBean) {
        if (baseBean.getStatus() == AppConfig.CODE_SUCCESS) {
            ToastUtils.showShort("注册成功");
        } else {
            String errorMsg = "注册失败" + baseBean.getMessage();
            ToastUtils.showShort(errorMsg);
        }
    }
}
