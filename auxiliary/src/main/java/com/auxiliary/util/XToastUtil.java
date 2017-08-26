package com.auxiliary.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 提示框工具类
 * Created by zj on 2017/8/25.
 */
public class XToastUtil {
    private Toast toast;
    private Context context;

    private XToastUtil(Context context) {
        this.context = context;
        toast = new Toast(context);
    }

    /**
     * 显示弹出提示
     *
     * @param content 提示内容
     */
    public void top(String content) {
        showCommon(content, Gravity.TOP, 14, Color.WHITE, 4, Color.BLACK);
    }

    /**
     * 显示弹出提示
     *
     * @param content 提示内容
     */
    public void center(String content) {
        showCommon(content, Gravity.CENTER, 14, Color.WHITE, 4, Color.BLACK);
    }

    /**
     * 显示弹出提示
     *
     * @param content 提示内容
     */
    public void bottom(String content) {
        showCommon(content, Gravity.BOTTOM, 14, Color.WHITE, 4, Color.BLACK);
    }

    /**
     * 显示顶部全宽弹出提示框
     *
     * @param content 提示内容
     */
    public void topWidth(String content) {
        showWidth(content, Gravity.TOP, 14, Color.WHITE, 4, 0x88000000, 0, 32);
    }

    /**
     * 显示顶部全宽弹出提示框
     *
     * @param content 提示内容
     */
    public void centerWidth(String content) {
        showWidth(content, Gravity.CENTER, 14, Color.WHITE, 4, 0x88000000, 0, 32);
    }

    /**
     * 显示顶部全宽弹出提示框
     *
     * @param content 提示内容
     */
    public void bottomWidth(String content) {
        showWidth(content, Gravity.BOTTOM, 14, Color.WHITE, 4, 0x88000000, 0, 32);
    }

    /**
     * 显示弹出提示
     *
     * @param content   提示内容
     * @param textColor 提示内容颜色
     * @param bgColor   提示背景颜色
     * @param radius    提示背景圆角
     */
    public void top(String content, @ColorInt int textColor, @ColorInt int bgColor, int radius) {
        showCommon(content, Gravity.TOP, 14, textColor, radius, bgColor);
    }

    /**
     * 显示弹出提示
     *
     * @param content   提示内容
     * @param textColor 提示内容颜色
     * @param bgColor   提示背景颜色
     * @param radius    提示背景圆角
     */
    public void center(String content, @ColorInt int textColor, @ColorInt int bgColor, int radius) {
        showCommon(content, Gravity.CENTER, 14, textColor, radius, bgColor);
    }

    /**
     * 显示弹出提示
     *
     * @param content   提示内容
     * @param textColor 提示内容颜色
     * @param bgColor   提示背景颜色
     * @param radius    提示背景圆角
     */
    public void bottom(String content, @ColorInt int textColor, @ColorInt int bgColor, int radius) {
        showCommon(content, Gravity.BOTTOM, 14, textColor, radius, bgColor);
    }

    /**
     * 显示顶部全宽弹出提示框
     *
     * @param content   提示内容
     * @param textColor 提示内容颜色
     * @param bgColor   提示背景颜色
     * @param radius    提示背景圆角
     * @param mHeight   提示的高度
     * @param margin    提示的边距
     */
    public void topWidth(String content, @ColorInt int textColor, @ColorInt int bgColor, int radius, int mHeight, int margin) {
        showWidth(content, Gravity.TOP, 14, textColor, radius, bgColor, mHeight, margin);
    }

    /**
     * 显示顶部全宽弹出提示框
     *
     * @param content   提示内容
     * @param textColor 提示内容颜色
     * @param bgColor   提示背景颜色
     * @param radius    提示背景圆角
     * @param mHeight   提示的高度
     * @param margin    提示的边距
     */
    public void centerWidth(String content, @ColorInt int textColor, @ColorInt int bgColor, int radius, int mHeight, int margin) {
        showWidth(content, Gravity.CENTER, 14, textColor, radius, bgColor, mHeight, margin);
    }

    /**
     * 显示顶部全宽弹出提示框
     *
     * @param content   提示内容
     * @param textColor 提示内容颜色
     * @param bgColor   提示背景颜色
     * @param radius    提示背景圆角
     * @param mHeight   提示的高度
     * @param margin    提示的边距
     */
    public void bottomWidth(String content, @ColorInt int textColor, @ColorInt int bgColor, int radius, int mHeight, int margin) {
        showWidth(content, Gravity.BOTTOM, 14, textColor, radius, bgColor, mHeight, margin);
    }

    /**
     * 显示全宽弹出提示框
     *
     * @param content   提示内容
     * @param gravity   提示位置
     * @param textSize  提示内容大小
     * @param textColor 提示内容颜色
     * @param radius    提示背景圆角
     * @param bgColor   提示背景颜色
     * @param mHeight   提示的高度
     * @param margin    提示的边距
     */
    private void showWidth(String content, int gravity, int textSize, @ColorInt int textColor, int radius, @ColorInt int bgColor, int mHeight, int margin) {
        if (context != null) {
            if (toast == null) toast = new Toast(context);
            toast.setGravity(gravity, 0, 0);

            //获取屏幕管理器
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            //获得屏幕的宽高
            int width = wm.getDefaultDisplay().getWidth();
            int height = wm.getDefaultDisplay().getHeight();
            if (width > 0 && height > 0) {
                LinearLayout layout = new LinearLayout(context);
                //  创建圆角矩形
                GradientDrawable mDrawableNormal = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{bgColor, bgColor});
                //  设置形状为矩形
                mDrawableNormal.setShape(GradientDrawable.RECTANGLE);
                //  矩形颜色为渐变
                mDrawableNormal.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                //  设置圆角半径值
                if (radius > 0) {
                    mDrawableNormal.setCornerRadii(new float[]{
                            dp2px(context, radius), dp2px(context, radius),
                            dp2px(context, radius), dp2px(context, radius),
                            dp2px(context, radius), dp2px(context, radius),
                            dp2px(context, radius), dp2px(context, radius)});
                }
                layout.setBackgroundDrawable(mDrawableNormal);
                layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                TextView textView = new TextView(context);
                textView.setPadding(dp2px(context, 16), dp2px(context, 8), dp2px(context, 16), dp2px(context, 8));
                textView.setTextColor(textColor);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize <= 0 ? 14 : textSize);
                textView.setText(content);
                layout.addView(textView, new LinearLayout.LayoutParams(width - dp2px(context, margin < 0 ? 32 : margin), mHeight == 0 ? (height / 10) : mHeight == -1 ? LinearLayout.LayoutParams.WRAP_CONTENT : mHeight));
                toast.setView(layout);
                toast.show();
            }
        }
    }

    /**
     * 显示普通的弹出提示
     *
     * @param content   提示内容
     * @param gravity   提示位置
     * @param textSize  提示内容大小
     * @param textColor 提示内容颜色
     * @param radius    提示背景圆角
     * @param bgColor   提示背景颜色
     */
    private void showCommon(String content, int gravity, int textSize, @ColorInt int textColor, int radius, @ColorInt int bgColor) {
        if (context != null) {
            if (toast == null) toast = new Toast(context);
            toast.setGravity(gravity, 0, 0);
            TextView textView = new TextView(context);
            textView.setPadding(dp2px(context, 16), dp2px(context, 8), dp2px(context, 16), dp2px(context, 8));
            textView.setTextColor(textColor);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize <= 0 ? 14 : textSize);
            //  创建圆角矩形
            GradientDrawable mDrawableNormal = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{bgColor, bgColor});
            //  设置形状为矩形
            mDrawableNormal.setShape(GradientDrawable.RECTANGLE);
            //  矩形颜色为渐变
            mDrawableNormal.setGradientType(GradientDrawable.LINEAR_GRADIENT);
            //  设置圆角半径值
            if (radius > 0) {
                mDrawableNormal.setCornerRadii(new float[]{
                        dp2px(context, radius), dp2px(context, radius),
                        dp2px(context, radius), dp2px(context, radius),
                        dp2px(context, radius), dp2px(context, radius),
                        dp2px(context, radius), dp2px(context, radius)});
            }
            textView.setBackgroundDrawable(mDrawableNormal);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = dp2px(context, 24);
            layoutParams.rightMargin = dp2px(context, 24);
            textView.setLayoutParams(layoutParams);
            textView.setText(content);
            toast.setView(textView);
            toast.show();
        }
    }

    /**
     * 取消弹出提示
     */
    public void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param context  运行环境
     * @param dipValue （DisplayMetrics类中属性density）
     * @return px尺寸
     */
    private int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
