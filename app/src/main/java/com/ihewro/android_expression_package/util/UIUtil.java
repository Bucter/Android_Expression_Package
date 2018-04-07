package com.ihewro.android_expression_package.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ihewro.android_expression_package.MyApplication;
import com.ihewro.android_expression_package.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * <pre>
 *     author : hewro
 *     e-mail : ihewro@163.com
 *     time   : 2018/04/06
 *     desc   : 全局操作的一些公共操作
 *     version: 1.0
 * </pre>
 */
public class UIUtil {


    /**
     * 获取全局Context，静态方法，你可以在任何位置调用该方法获取Context
     * @return
     */
    public static Context getContext() {
        return MyApplication.getContext();
    }

    /**
     * 获取资源对象
     *
     * @return
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 获取资源文件字符串
     *
     * @param resId
     * @return
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * 获取资源文件字符串数组
     *
     * @param resId
     * @return
     */
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 获取资源文件颜色
     *
     * @param resId
     * @return
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 获取状态栏高度
     *
     * @param context context
     * @return 状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }


    public static void setImageToImageView(int status, String url, ImageView imageView){
        switch (status){
            case -1://apk内置图片
                InputStream is= null;
                try {
                    is = UIUtil.getContext().getAssets().open(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Bitmap bitmap= BitmapFactory.decodeStream(is);
                Glide.with(UIUtil.getContext()).load(bitmap).into(imageView);
                break;

            case 1://存储在sd卡中
                //获取路径
                Glide.with(UIUtil.getContext()).load(url).into(imageView);
                break;

            case 2://加载网络地址
                Glide.with(UIUtil.getContext()).load(url).into(imageView);
                break;
        }

    }
}
