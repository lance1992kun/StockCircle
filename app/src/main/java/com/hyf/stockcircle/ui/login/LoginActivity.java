package com.hyf.stockcircle.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hyf.stockcircle.R;
import com.hyf.stockcircle.data.entity.LoginBean;
import com.hyf.stockcircle.ui.register.RegisterActivity;
import com.hyf.stockcircle.util.DialogUtil;
import com.syk.lib.base.BaseActivity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/07 21:07
 *   desc    : 登录界面
 *   version :1.0
 * </pre>
 */

public class LoginActivity extends BaseActivity implements LoginView {
    /**
     * 手机号编辑框
     */
    private EditText mPhoneEdit = null;
    /**
     * 密码编辑框
     */
    private EditText mPasswordEdit = null;
    /**
     * 桥梁类
     */
    private LoginPresenterImpl mLoginPresenter = null;

    @Override
    public void initData(Bundle bundle) {
        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        // 手机号编辑框
        mPhoneEdit = F(R.id.mPhoneEdit);
        // 密码编辑框
        mPasswordEdit = F(R.id.mPasswordEdit);
        // 按键事件监听
        setOnClick(F(R.id.mCloseBtn));
        setOnClick(F(R.id.mLoginBtn));
        setOnClick(F(R.id.mRegisterBtn));
        setOnClick(F(R.id.mForgetBtn));
        setOnClick(F(R.id.mLoginHint));
    }

    @Override
    public void doBusiness(Context context) {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            // 关闭按钮
            case R.id.mCloseBtn:
                this.finish();
                break;
            // 登录按钮
            case R.id.mLoginBtn:
                String phone = mPhoneEdit.getText().toString().trim();
                String passWord = mPasswordEdit.getText().toString().trim();
                if (!RegexUtils.isMobileExact(phone)) {
                    ToastUtils.showShort("请输入正确的手机号！");
                    return;
                }
                if (passWord.length() < 6) {
                    ToastUtils.showShort("请输入6位以上的密码！");
                    return;
                }
                mLoginPresenter.doLogin(phone, passWord);
                break;
            // 注册按钮
            case R.id.mRegisterBtn:
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                this.finish();
                break;
            // 忘记密码
            case R.id.mForgetBtn:
                break;
            // 法律提醒按钮
            case R.id.mLoginHint:
                break;
            default:
                break;
        }
    }

    @Override
    public void showFailed(String errorMsg) {
        ToastUtils.showShort(errorMsg);
    }

    @Override
    public void showDialog(boolean isShow) {
        if (isShow) {
            DialogUtil.getInstance().showNetDialog(this, "正在登录……");
        } else {
            DialogUtil.getInstance().hideNetDialog();
        }
    }

    @Override
    public void doLoginSuccess(LoginBean bean) {
        if (bean.getStatus() == 200) {
            ToastUtils.showShort("登录成功");
        }
    }
}
