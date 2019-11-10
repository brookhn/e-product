package com.pp.server.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_HOUR = "yyyy-MM-dd HH";
    public static final String DATE_STR_TIME = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_TIME_NUM = "yyyyMMddHHmmss";
    public static final String DATE = "yyyy-MM-dd";
    public static final String DATE_NUM = "yyyyMMdd";
    public static final String TIME = "HH:mm:ss";
    public static final String TIME_NUM = "HHmmss";
    public static final String STAMP_TIME = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String MONTH_TIME_NUM = "MMddHHmmss";

    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 生成时间格式化对象
     *
     * @return
     */
    public static SimpleDateFormat getyyyyMMddHHmmss() {
        return new SimpleDateFormat(DATE_TIME_NUM);
    }

    public static String getFormatDateTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
