package com.hyf.stockcircle.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.FragmentUtils;
import com.hyf.stockcircle.R;
import com.hyf.stockcircle.ui.home.HomeFragment;
import com.hyf.stockcircle.ui.fragment.MessageFragment;
import com.hyf.stockcircle.ui.fragment.ProfileFragment;
import com.hyf.stockcircle.ui.fragment.StockFragment;
import com.syk.lib.base.BaseActivity;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/07
 *     desc   : 主界面
 *     version: 1.0
 * </pre>
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    /**
     * 主页、消息、股友圈、我的界面集合
     */
    private Fragment[] mFragments = new Fragment[4];
    /**
     * 当前下标
     */
    private int curIndex = 0;

    @Override
    public void initData(Bundle bundle) {
        // 初始化各种界面
        mFragments[0] = HomeFragment.newInstance();
        mFragments[1] = MessageFragment.newInstance();
        mFragments[2] = StockFragment.newInstance();
        mFragments[3] = ProfileFragment.newInstance();
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        // 导航栏监听
        ((RadioGroup) F(R.id.mNavigationGroup)).setOnCheckedChangeListener(this);
        // 添加界面到布局中
        FragmentUtils.add(getSupportFragmentManager(), mFragments, R.id.fragment_container, curIndex);
    }

    @Override
    public void doBusiness(Context context) {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    /**
     * 导航栏监听
     *
     * @param checkedId 哪个按钮
     */
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            // 首页
            case R.id.mHomeRb:
                switchFragment(0);
                break;
            // 消息
            case R.id.mMessageRb:
                switchFragment(1);
                break;
            // 股友圈
            case R.id.mStockRb:
                switchFragment(2);
                break;
            // 我的
            case R.id.mProfileRb:
                switchFragment(3);
                break;
            default:
                break;
        }
    }

    /**
     * 切换界面
     *
     * @param index 要切换到的界面
     */
    private void switchFragment(int index) {
        FragmentUtils.showHide(curIndex = index, mFragments);
    }

}
