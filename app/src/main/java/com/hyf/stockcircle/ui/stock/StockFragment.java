package com.hyf.stockcircle.ui.stock;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.hyf.stockcircle.R;
import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CircleDetailBean;
import com.hyf.stockcircle.data.entity.CircleListBean;
import com.hyf.stockcircle.data.entity.CollectionBean;
import com.hyf.stockcircle.data.entity.LikeBean;
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

public class StockFragment extends BaseFragment implements StockView {
    /**
     * 桥梁类
     */
    private StockPresenterImpl mStockPresenterImpl = null;

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
        mStockPresenterImpl = new StockPresenterImpl(this);
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

    /**
     * 联网失败
     *
     * @param errorMsg 错误信息
     */
    @Override
    public void showFailed(String errorMsg) {

    }

    /**
     * 显示联网对话框
     *
     * @param isShow 是否显示联网对话框
     */
    @Override
    public void showDialog(boolean isShow) {

    }

    /**
     * 发布股友圈成功
     *
     * @param bean 回调实体类
     */
    @Override
    public void doPublishSuccess(BaseBean bean) {

    }

    /**
     * 收藏
     *
     * @param bean 回调实体类
     */
    @Override
    public void doCollectSuccess(CollectionBean bean) {

    }

    /**
     * 点赞
     *
     * @param bean 回调实体类
     */
    @Override
    public void doLikeSuccess(LikeBean bean) {

    }

    /**
     * 获取股友圈列表成功
     *
     * @param circleListBean 回调实体类
     */
    @Override
    public void getCircleListSuccess(CircleListBean circleListBean) {

    }

    /**
     * 获取股友圈详情成功
     *
     * @param circleDetailBean 回调实体类
     */
    @Override
    public void getCircleDetailSuccess(CircleDetailBean circleDetailBean) {

    }

    /**
     * 评论成功
     *
     * @param bean 回调实体类
     */
    @Override
    public void doCommentSuccess(BaseBean bean) {

    }
}
