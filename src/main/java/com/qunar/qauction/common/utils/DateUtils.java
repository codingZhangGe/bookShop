package com.qunar.qauction.common.utils;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * DateUtils: 封装对Date 类型操作各种方法
 * <p/>
 * Created by lingtong on 16-3-3.
 */
public class DateUtils {

    /* 默认格式 */
    private final static String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date转String，默认格式
     *
     * @param date java日期格式
     * @return 字符串
     */
    public static String dateToStr(Date date) {
        return DateUtils.dateToStr(date, DateUtils.PATTERN_DEFAULT);
    }

    /**
     * Date转String，自定义格式
     *
     * @param date java日期格式
     * @param pattern 格式串
     * @return 字符串
     */
    public static String dateToStr(Date date, String pattern) {
        LocalDateTime dateTime = new LocalDateTime(date);
        return dateTime.toString(pattern);
    }

    /**
     * String转Date，默认格式
     *
     * @param dateStr 日期字符串
     * @return Date
     */
    public static Date strToDate(String dateStr) {
        return DateUtils.strToDate(dateStr, DateUtils.PATTERN_DEFAULT);
    }

    /**
     * String转Date，自定义格式
     *
     * @param dateStr 日期字符串
     * @param pattern 格式串
     * @return Date
     */
    public static Date strToDate(String dateStr, String pattern) {
        LocalDateTime dateTime = DateTimeFormat.forPattern(pattern).parseLocalDateTime(dateStr);
        return dateTime.toDate();
    }

    /**
     * Long转日期格式的字符串，默认格式
     *
     * @param dateLong long串
     * @return 日期格式的字符串
     */
    public static String longToDateStr(Long dateLong) {
        return DateUtils.longToDateStr(dateLong, DateUtils.PATTERN_DEFAULT);
    }

    /**
     * Long转日期格式的字符串，自定义格式
     *
     * @param dateLong long串
     * @param pattern 格式串
     * @return 日期格式的字符串
     */
    public static String longToDateStr(Long dateLong, String pattern) {
        LocalDateTime dateTime = new LocalDateTime(DateUtils.longToDate(dateLong));
        return dateTime.toString(pattern);
    }

    /**
     * Long转Date
     *
     * @param dateLong long串
     * @return Date
     */
    public static Date longToDate(Long dateLong) {
        return new Date(dateLong);
    }

}
