package com.hyf.stockcircle.data.entity;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : 验证码实体类
 *     version: 1.0
 * </pre>
 */

public class CodeBean extends BaseBean{
    /**
     * 验证码id
     */
    private int codeId = 0;

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }
}
