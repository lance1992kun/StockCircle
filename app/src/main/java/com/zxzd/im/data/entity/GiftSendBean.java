package com.zxzd.im.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/12 11:59
 *   desc    : 发送礼物返回实体类
 *   version : 1.0
 * </pre>
 */

public class GiftSendBean extends BaseBean {
    /**
     * 礼物详情
     */
    private GiftDetailBean giftDetails;

    public GiftDetailBean getGiftDetails() {
        return giftDetails;
    }

    public void setGiftDetails(GiftDetailBean giftDetails) {
        this.giftDetails = giftDetails;
    }
}
