package com.zxzd.im.ui.forget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.EmptyUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.syk.lib.base.BaseActivity;
import com.zxzd.im.R;
import com.zxzd.im.data.Constant;
import com.zxzd.im.data.entity.BaseBean;
import com.zxzd.im.data.entity.CodeBean;
import com.zxzd.im.util.DialogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/09 08:27
 *   desc    : 忘记密码界面
 *   version :1.0
 * </pre>
 */

public class ForgetActivity extends BaseActivity implements ForgetView {
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
     * 重复密码编辑框
     */
    private EditText mRepeatEdit = null;
    /**
     * 验证码计时器
     */
    private Disposable mCodeTimer = null;
    /**
     * 获取验证码按钮
     */
    private Button mCodeBtn = null;
    /**
     * 验证码ID保存
     */
    private int codeId = 0;
    /**
     * 手机号码保存字符串
     */
    private String phoneNumber = null;
    /**
     * 桥梁类
     */
    private ForgetPresenterImpl mForgetPresenter = null;

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
        mForgetPresenter = new ForgetPresenterImpl(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_forget;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        mPhoneEdit = F(R.id.mPhoneEdit);
        mCodeEdit = F(R.id.mCodeEdit);
        mPasswordEdit = F(R.id.mPasswordEdit);
        mRepeatEdit = F(R.id.mRepeatEdit);
        mCodeBtn = F(R.id.mCodeBtn);
        // 监听事件
        setOnClick(mCodeBtn);
        setOnClick(F(R.id.mCloseBtn));
        setOnClick(F(R.id.mCodeBtn));
    }

    @Override
    public void doBusiness(Context context) {

    }

    /**
     * 验证数据
     */
    private void verifyData() {
        phoneNumber = mPhoneEdit.getText().toString().trim();
        String codeNumber = mCodeEdit.getText().toString().trim();
        String passwordString = mPasswordEdit.getText().toString().trim();
        String repeatString = mRepeatEdit.getText().toString().trim();
        if (!RegexUtils.isMobileExact(phoneNumber)) {
            ToastUtils.showShort("请输入正确的手机号！");
            return;
        }
        if (EmptyUtils.isEmpty(codeNumber)) {
            ToastUtils.showShort("请输入正确的验证码！");
            return;
        }
        if (passwordString.length() < 6) {
            ToastUtils.showShort("请输入6位以上的密码！");
            return;
        }
        if (!passwordString.equals(repeatString)) {
            ToastUtils.showShort("两次输入的密码不一样！");
            return;
        }
        mForgetPresenter.doSubmit(codeNumber, codeId, phoneNumber, passwordString, repeatString);
    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            // 关闭按钮
            case R.id.mCloseBtn:
                this.finish();
                break;
            // 获取验证码按钮
            case R.id.mCodeBtn:
                phoneNumber = mPhoneEdit.getText().toString();
                if (!RegexUtils.isMobileExact(phoneNumber)) {
                    ToastUtils.showShort("请输入正确的手机号");
                    return;
                } else {
                    mForgetPresenter.getCode(phoneNumber, "", Constant.CODE_TYPE_FORGET);
                }
                break;
            // 提交按钮
            case R.id.mSubmitBtn:
                verifyData();
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
     * 是否显示联网对话框
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
     * 获取验证码
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
     * 修改密码成功
     *
     * @param baseBean 回调实体类
     */
    @Override
    public void doSubmitSuccess(BaseBean baseBean) {
        if (baseBean.getStatus() == Constant.CODE_SUCCESS) {
            ToastUtils.showShort("修改密码成功");
        } else {
            String errorMsg = "修改密码失败" + baseBean.getMessage();
            ToastUtils.showShort(errorMsg);
        }
    }
}
