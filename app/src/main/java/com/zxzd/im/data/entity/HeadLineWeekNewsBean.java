package com.zxzd.im.data.entity;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/13
 *     desc   : 7*24时讯实体类
 *     version: 1.0
 * </pre>
 */

public class HeadLineWeekNewsBean {
    /**
     * 内容
     */
    private String content;
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 唯一ID
     */
    private int id;
    /**
     * 修改日期
     */
    private long modifyDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(int modifyDate) {
        this.modifyDate = modifyDate;
    }
}
