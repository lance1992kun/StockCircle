package com.zxzd.im.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/10 20:39
 *   desc    : 收藏实体类
 *   version :1.0
 * </pre>
 */

public class CollectionBean extends BaseBean {
    /**
     * favorite为收藏，unfavorite为未收藏
     */
    private boolean type;

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
