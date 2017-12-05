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
 *     desc   : 股友圈界面
 *     version: 1.0
 * </pre>
 */

public class StockFragment extends BaseFragment {
    /**
     * 获取股友圈实例
     *
     * @return 股友圈实例
     */
    public static StockFragment newInstance() {
        Bundle args = new Bundle();
        StockFragment fragment = new StockFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_stock;
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
