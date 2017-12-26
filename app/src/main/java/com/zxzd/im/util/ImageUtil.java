package com.zxzd.im.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/09
 *     desc   : 图片加载工具
 *     version: 1.0
 * </pre>
 */

public class ImageUtil {
    /**
     * 根据url加载到指定的Activity中
     *
     * @param activity  activity对象
     * @param url       图片地址
     * @param imageView 要显示图片的ImageVIew
     */
    public static void displayImage(Activity activity, String url, ImageView imageView) {
        Glide.with(activity).load(url).into(imageView);
    }

    /**
     * 根据url加载到指定的fragment中
     *
     * @param fragment  fragment对象
     * @param url       图片地址
     * @param imageView 要显示图片的ImageVIew
     */
    public static void displayImage(Fragment fragment, String url, ImageView imageView) {
        Glide.with(fragment).load(url).into(imageView);
    }

    /**
     * 根据url加载到指定的界面中
     *
     * @param context   上下文对象
     * @param url       图片地址
     * @param imageView 要显示图片的ImageVIew
     */
    public static void displayImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

}
