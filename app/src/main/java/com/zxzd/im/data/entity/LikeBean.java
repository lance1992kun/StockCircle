package com.zxzd.im.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 20:42
 *   desc    : 点赞实体类
 *   version :1.0
 * </pre>
 */

public class LikeBean extends BaseBean {
    /**
     * like：已点赞 ； unlike：取消点赞
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
