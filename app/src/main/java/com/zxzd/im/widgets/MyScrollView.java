package com.zxzd.im.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/11
 *     desc   : 自定义的滑动布局
 *     version: 1.0
 * </pre>
 */

public class MyScrollView extends ScrollView {
    private int downX;
    private int downY;
    private int mTouchSlop;
    private int calCount;
    private ScrollChangedCallBack mScrollChangeCallBack;
    private ScrollBottomCallBack mScrollBottomCallBack;

    public void setScrollChangeCallBack(ScrollChangedCallBack mScrollChangeCallBack) {
        this.mScrollChangeCallBack = mScrollChangeCallBack;
    }

    public void setScrollBottomCallBack(ScrollBottomCallBack mScrollBottomCallBack) {
        this.mScrollBottomCallBack = mScrollBottomCallBack;
    }

    public MyScrollView(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) e.getRawX();
                downY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) e.getRawY();
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }
        }
        return super.onInterceptTouchEvent(e);
    }

    @Override
    protected void onScrollChanged(int l, final int t, final int oldl, final int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        // 滑动监听
        if (mScrollChangeCallBack != null) {
            mScrollChangeCallBack.onScrollChanged();
        }
        // 监听ScrollView滑动到底部
        View view = this.getChildAt(0);
        if (this.getHeight() + this.getScrollY() == view.getHeight()) {
            calCount++;
            if (calCount == 1) {
                if (mScrollBottomCallBack != null) {
                    mScrollBottomCallBack.onScrollBottom();
                }
            }
        } else {
            calCount = 0;
        }
    }

    public interface ScrollChangedCallBack {
        void onScrollChanged();
    }

    public interface ScrollBottomCallBack {
        void onScrollBottom();
    }
}
