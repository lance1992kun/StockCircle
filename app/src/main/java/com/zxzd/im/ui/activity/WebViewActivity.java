package com.zxzd.im.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.just.agentweb.AgentWeb;
import com.syk.lib.base.BaseActivity;
import com.zxzd.im.R;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/27 16:03
 *   desc    : 各种WebView界面
 *   version : 1.0
 * </pre>
 */

public class WebViewActivity extends BaseActivity {
    /**
     * WebView封装
     */
    private AgentWeb mAgentWeb;
    /**
     * 父布局
     */
    private LinearLayout mLinearLayout;
    /**
     * 加载的网页或者内容
     */
    private String url;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 加载类型：0>>>内容；1:网页
     */
    private int loadType;

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause(); //暂停应用内所有 WebView ， 需谨慎。
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void initData(Bundle bundle) {
        if (bundle != null) {
            loadType = bundle.getInt("type");
            url = bundle.getString("url");
            imgUrl = bundle.getString("imgUrl");
            LogUtils.e("content>>>" + url + "imgUrl>>>" + imgUrl);
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_webview;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        mLinearLayout = F(R.id.mContent);
    }

    @Override
    public void doBusiness(Context context) {
        mAgentWeb = AgentWeb.with(this)// 传入Activity or Fragment
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))// 传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .createAgentWeb()// 创建对象
                .ready()// 准备就绪
                .go("");
        if (loadType == 0) {
            mAgentWeb.getLoader().loadData(url, "text/html; charset=UTF-8", null);
        } else {
            mAgentWeb.getLoader().loadUrl(url);
        }
    }

    @Override
    public void onWidgetClick(View view) {

    }

}
