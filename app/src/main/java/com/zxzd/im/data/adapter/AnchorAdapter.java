package com.zxzd.im.data.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxzd.im.R;
import com.zxzd.im.data.entity.LiveBean;

import java.util.List;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/26 14:57
 *   desc    : 主播适配器
 *   version : 1.0
 * </pre>
 */

public class AnchorAdapter extends BaseQuickAdapter<LiveBean, BaseViewHolder> {
    public AnchorAdapter(@Nullable List<LiveBean> data) {
        super(R.layout.item_anchor, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveBean item) {

    }
}
