package com.hyf.stockcircle.ui.register;

import com.hyf.stockcircle.base.BaseView;
import com.hyf.stockcircle.data.entity.BaseBean;
import com.hyf.stockcircle.data.entity.CodeBean;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/12/03
 *     desc   : 注册界面 - 界面操作对象
 *     version: 1.0
 * </pre>
 */

interface RegisterView extends BaseView {
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
     * 注册成功回调
     *
     * @param baseBean 回调实体类
     */
    void doRegisterSuccess(BaseBean baseBean);
}
