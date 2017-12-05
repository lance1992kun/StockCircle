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
 *     desc   : 我的界面
 *     version: 1.0
 * </pre>
 */

public class ProfileFragment extends BaseFragment {
    /**
     * 获取我的实例
     *
     * @return 我的实例
     */
    public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_profile;
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
