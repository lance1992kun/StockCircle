package com.hyf.stockcircle.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.hyf.stockcircle.R;
import com.syk.lib.base.BaseFragment;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/09
 *     desc   : 消息界面
 *     version: 1.0
 * </pre>
 */

public class MessageFragment extends BaseFragment {
    /**
     * 获取消息实例
     *
     * @return 消息实例
     */
    public static MessageFragment newInstance() {
        Bundle args = new Bundle();
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_message;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {

    }

    @Override
    public void doBusiness(Context context) {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
