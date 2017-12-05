package com.hyf.stockcircle;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.syk.lib.base.BaseApplication;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/09
 *     desc   : 自定义Application对象
 *     version: 1.0
 * </pre>
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化工具类
        Utils.init(this);
        // 初始化日志
        initLog();
    }

    /**
     * 初始化日志
     */
    private void initLog() {
        LogUtils.Config config = LogUtils.getConfig()
                // 设置log总开关，包括输出到控制台和文件，默认开
                .setLogSwitch(BuildConfig.DEBUG)
                // 设置是否输出到控制台开关，默认开
                .setConsoleSwitch(BuildConfig.DEBUG)
                // 设置log全局标签，默认为空
                // 当全局标签不为空时，我们输出的log全部为该tag，
                // 为空时，如果传入的tag为空那就显示类名，否则显示tag
                .setGlobalTag(null)
                // 设置log头信息开关，默认为开
                .setLogHeadSwitch(true)
                // 打印log时是否存到文件的开关，默认关
                .setLog2FileSwitch(false)
                // 当自定义路径为空时，写入应用的/cache/log/目录中
                .setDir("")
                // 当文件前缀为空时，默认为"util"，即写入文件为"util-MM-dd.txt"
                .setFilePrefix("")
                // 输出日志是否带边框开关，默认开
                .setBorderSwitch(true)
                // log的控制台过滤器，和logcat过滤器同理，默认Verbose
                .setConsoleFilter(LogUtils.V)
                // log文件过滤器，和logcat过滤器同理，默认Verbose
                .setFileFilter(LogUtils.V)
                // log栈深度，默认为1
                .setStackDeep(1);
        LogUtils.d(config.toString());
    }
}
