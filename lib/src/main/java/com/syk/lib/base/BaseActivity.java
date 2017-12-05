package com.syk.lib.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;

import static com.syk.lib.AppConfig.FAST_CLICK_PERIOD;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/08/17
 *     desc   : activity基类
 *     version: 1.0
 * </pre>
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView, View.OnClickListener {
    /**
     * 用来保存View的稀疏数组
     */
    private SparseArray<View> mViews = null;
    /**
     * 当前Activity渲染的视图View
     */
    protected View contentView;
    /**
     * 上次点击时间
     */
    private long lastClick = 0;
    /**
     * 基类对象
     */
    protected BaseActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化稀疏数组用来保存子类的View对象
        mViews = new SparseArray<>();
        mActivity = this;
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
        setBaseView();
        initView(savedInstanceState, contentView);
        doBusiness(this);
    }

    /**
     * 设置布局文件
     */
    protected void setBaseView() {
        setContentView(contentView = LayoutInflater.from(this).inflate(bindLayout(), null));
    }

    /**
     * 判断是否快速点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= FAST_CLICK_PERIOD) {
            lastClick = now;
            return false;
        }
        return true;
    }

    @Override
    public void onClick(final View view) {
        // 如果不是快速点击的话才响应点击事件
        if (!isFastClick()) {
            onWidgetClick(view);
        }
    }

    /**
     * 通过ID找到View(代替FindViewByID)
     *
     * @param viewID ID
     * @return View
     */
    @SuppressWarnings("unchecked")
    public <E extends View> E F(int viewID) {
        E view = (E) mViews.get(viewID);
        if (view == null) {
            view = (E) findViewById(viewID);
            mViews.put(viewID, view);
        }
        return view;
    }

    /**
     * 设置点击事件
     *
     * @param mViews 需要设置点击事件的View
     */
    public <V extends View> void setOnClick(V... mViews) {
        if (mViews == null) {
            return;
        }
        for (View mView : mViews) {
            mView.setOnClickListener(this);
        }
    }
}
