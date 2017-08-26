package com.auxiliary.util;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 编辑框工具类
 * Created by zj on 2017/8/23.
 */
public class XEditUtil {

    private static XEditUtil instance = new XEditUtil();

    private XEditUtil() {
    }

    public static XEditUtil getInstance() {
        return instance;
    }

    /**
     * 禁止EditText输入空格
     *
     * @param editText EditText
     */
    public void setInhibitInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ")) {
                    return "";
                } else {
                    return source;
                }
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    /**
     * 禁止EditText输入特殊字符
     *
     * @param editText EditText
     */
    public void setInhibitInputSpeChat(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                String speChat = "[`~!@#$%^&*()+=|{}':;',[].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]";
                Pattern pattern = Pattern.compile(speChat);
                Matcher matcher = pattern.matcher(source.toString());
                if (matcher.find()) {
                    return "";
                } else {
                    return null;
                }
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    /**
     * 设置 editText 是否聚焦编辑
     *
     * @param editText 输入文本框
     * @param able     是否可输入
     */
    public void setEditable(EditText editText, boolean able) {
        if (able) {
            //设置为可编辑
            editText.setEnabled(true);
            editText.setFocusable(true);//获取焦点
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();//请求焦点
            editText.requestFocusFromTouch();
        } else {
            //设置为不可编辑
            editText.setFocusable(false);
            editText.setEnabled(false);
        }
    }
}
