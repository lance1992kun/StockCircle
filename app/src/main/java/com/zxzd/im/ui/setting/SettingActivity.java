package com.zxzd.im.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syk.lib.base.BaseActivity;
import com.zxzd.im.R;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/26 19:01
 *   desc    : 设置界面
 *   version : 1.0
 * </pre>
 */

public class SettingActivity extends BaseActivity {
    /**
     * 标题
     */
    private TextView mTitle = null;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        // 标题
        mTitle = F(R.id.mTitle);
        // 监听事件
        F(R.id.mBackImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setOnClick(F(R.id.mSafeLay));
        setOnClick(F(R.id.mTeamLay));
        setOnClick(F(R.id.mContactLay));
        setOnClick(F(R.id.mFeedBackLay));
        setOnClick(F(R.id.mShareLay));
        setOnClick(F(R.id.mLogoutBtn));
    }

    @Override
    public void doBusiness(Context context) {

    }

    @Override
    public void onWidgetClick(View view) {
        Intent mIntent = new Intent();
        switch (view.getId()) {
            // 账号与安全
            case R.id.mSafeLay:
                break;
            // 团队介绍
            case R.id.mTeamLay:
                break;
            // 联系我们
            case R.id.mContactLay:
                break;
            // 意见反馈
            case R.id.mFeedBackLay:
                break;
            // 分享股友圈
            case R.id.mShareLay:
                break;
            // 登出
            case R.id.mLogoutBtn:
                break;
            default:
                break;
        }
        // 跳转界面
        finish();
        startActivity(mIntent);
    }
}
