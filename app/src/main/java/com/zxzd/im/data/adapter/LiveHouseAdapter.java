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
 *   time    : 2017/12/26 15:01
 *   desc    : 直播间适配器
 *   version : 1.0
 * </pre>
 */

public class LiveHouseAdapter extends BaseQuickAdapter<LiveBean, BaseViewHolder> {
    public LiveHouseAdapter(@Nullable List<LiveBean> data) {
        super(R.layout.item_live_house, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveBean item) {

    }
}
