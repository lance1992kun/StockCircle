package com.hyf.stockcircle.ui.forget;

import com.hyf.stockcircle.base.BaseView;
import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CodeBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/09 13:13
 *   desc    : GUI接口
 *   version :1.0
 * </pre>
 */

interface ForgetView extends BaseView{
    /**
     * 点击获取验证码之后
     */
    void onGetCode();

    /**
     * 获取验证码成功
     *
     * @param codeBean 验证码实体类
     */
    void getCodeSuccess(CodeBean codeBean);

    /**
     * 更改密码成功回调
     *
     * @param baseBean 回调实体类
     */
    void doSubmitSuccess(BaseBean baseBean);
}
