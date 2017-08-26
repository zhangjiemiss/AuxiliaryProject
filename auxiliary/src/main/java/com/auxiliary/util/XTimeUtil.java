package com.auxiliary.util;

import java.util.Date;

/**
 * 时间类工具
 * Created by zj on 2017/8/26 0026.
 */
public class XTimeUtil {

    /**
     * 获取时间戳（秒）
     *
     * @return 时间戳
     */
    public String getTimeStamp() {
        long time = new Date().getTime();
        return String.valueOf(time);
    }
}
