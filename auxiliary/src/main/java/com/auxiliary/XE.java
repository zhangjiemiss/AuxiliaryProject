package com.auxiliary;

/**
 * 我的工具类
 * Created by zj on 2017/8/26 0026.
 */
public class XE {
    private static final XE instance = new XE();

    private XE() {
    }

    /**
     * 获取实例对象
     *
     * @return 实例对象
     */
    public static XE get() {
        return instance;
    }

}
