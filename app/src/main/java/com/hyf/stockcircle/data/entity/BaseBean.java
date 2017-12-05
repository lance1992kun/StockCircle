package com.hyf.stockcircle.data.entity;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : 实体基类
 *     version: 1.0
 * </pre>
 */

public class BaseBean {
    /**
     * 提示信息
     */
    private String message = null;
    /**
     * 状态码(返回成功为200)
     */
    private int status = 0;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
