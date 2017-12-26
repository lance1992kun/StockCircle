package com.zxzd.im.ui.forget;

import com.zxzd.im.base.BasePresenter;
import com.zxzd.im.data.entity.BaseBean;
import com.zxzd.im.data.entity.CodeBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/09 13:13
 *   desc    : 桥梁接口
 *   version :1.0
 * </pre>
 */

interface ForgetPresenter extends BasePresenter {
    /**
     * 获取验证码
     *
     * @param mobile 手机号(不能为空)
     * @param token  用户唯一标识(当type=4时，token必填，其他可以为空)
     * @param type   类型(1:注册 2:找回密码 4:实名认证)
     */
    void getCode(String mobile, String token, int type);

    /**
     * 获取验证码成功
     *
     * @param codeBean 验证码实体类
     */
    void getCodeSuccess(CodeBean codeBean);

    /**
     * 确认更改密码操作
     *
     * @param code            验证码
     * @param code_id         验证码id
     * @param mobile          手机号
     * @param password        密码
     * @param repeat_password 第二次输入密码
     */
    void doSubmit(String code, int code_id, String mobile, String password, String repeat_password);

    /**
     * 执行注册操作成功
     */
    void doSubmitSuccess(BaseBean baseBean);
}
