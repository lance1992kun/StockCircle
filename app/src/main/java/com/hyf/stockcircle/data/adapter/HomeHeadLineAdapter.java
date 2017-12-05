package com.hyf.stockcircle.data.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hyf.stockcircle.R;
import com.hyf.stockcircle.data.entity.HeadLineNewsBean;
import com.hyf.stockcircle.util.ImageUtil;

import java.util.List;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/11
 *     desc   : 首页头条信息适配器
 *     version: 1.0
 * </pre>
 */

public class HomeHeadLineAdapter extends BaseQuickAdapter<HeadLineNewsBean, BaseViewHolder> {
    public HomeHeadLineAdapter(@Nullable List<HeadLineNewsBean> data) {
        super(R.layout.item_home_news, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HeadLineNewsBean item) {
        // 设置下层半透明
        helper.getView(R.id.mItemHomeDownLay).getBackground().setAlpha(150);
        // 是否显示精品图片
        if (item.isHot()) {
            helper.getView(R.id.mItemHomeCreamImg).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.mItemHomeCreamImg).setVisibility(View.GONE);
        }
        // 显示文字
        helper.setText(R.id.mItemHomeTitle, item.getTitle());
        // 显示图片
        ImageView mImageView = helper.getView(R.id.mItemHomeImg);
        ImageUtil.displayImage(mContext, item.getImageUrl(), mImageView);
    }
}
