package com.zxzd.im.data.entity;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/10
 *     desc   : 文字轮播实体类
 *     version: 1.0
 * </pre>
 */

public class TextSwitchBean {
    /**
     * 轮播内容
     */
    private String content;
    /**
     * 轮播内容的跳转链接
     */
    private String url;

    /**
     * 构造函数
     *
     * @param content 内容
     * @param url     内容的跳转链接
     */
    public TextSwitchBean(String content, String url) {
        this.content = content;
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
