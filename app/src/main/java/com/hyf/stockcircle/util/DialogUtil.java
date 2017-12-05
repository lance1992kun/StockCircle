package com.hyf.stockcircle.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/14
 *     desc   : 弹框工具
 *     version: 1.0
 * </pre>
 */

public class DialogUtil {
    /**
     * 用来显示联网的对话框
     */
    private ProgressDialog mConnectingDialog;
    /**
     * 对话框工具类单例
     */
    private static final DialogUtil instance = new DialogUtil();

    /**
     * 获取单例
     *
     * @return 对话框工具类单例
     */
    public static DialogUtil getInstance() {
        return instance;
    }

    /**
     * 私有构造
     */
    private DialogUtil() {

    }

    /**
     * 显示连接对话框
     *
     * @param mContext 上下文对象
     * @param msg      要显示的信息
     */
    public void showNetDialog(Context mContext, String msg) {
        // 没有对话框的话显示连接对话框
        if (mConnectingDialog == null) {
            mConnectingDialog = new ProgressDialog(mContext);
            mConnectingDialog.setMessage(msg);
            mConnectingDialog.setCancelable(false);
            mConnectingDialog.setCanceledOnTouchOutside(false);
            mConnectingDialog.show();
        }
    }

    /**
     * 隐藏连接对话框
     */
    public void hideNetDialog() {
        if (mConnectingDialog != null && mConnectingDialog.isShowing()) {
            mConnectingDialog.dismiss();
            mConnectingDialog = null;
        }
    }
}
