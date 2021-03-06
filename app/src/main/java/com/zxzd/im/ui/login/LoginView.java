package com.zxzd.im.ui.login;

import com.zxzd.im.base.BaseView;
import com.zxzd.im.data.entity.UserBean;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/08 12:25
 *   desc    : 登录View
 *   version :1.0
 * </pre>
 */

interface LoginView extends BaseView {
    /**
     * 登录成功
     * @param bean 登录实体类
     */
    void doLoginSuccess(UserBean bean);
}
