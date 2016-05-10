package com.xupt.bookshop.common.utils;

import com.xupt.bookshop.common.Constants;
import com.xupt.bookshop.common.exceptions.ParameterException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author ge.zhang created on 16-4-14
 * @version 1.0
 */
public class DateTimeUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeUtil.class);

    private static final DateTimeFormatter FULL_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm:ss");
    private static final DateTimeFormatter REQUEST_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter RESPONSE_FORMATTER = DateTimeFormat.forPattern("HH:mm");

    /**
     * 获取yyyy-MM-dd HH:mm:ss样式的字符串
     */
    public static String getStandardStr(Date date) {
        DateTime dateTime = new DateTime(date.getTime());
        return dateTime.toString(FULL_FORMATTER);
    }

    /**
     * 获取yyyy-MM-dd样式的字符串
     */
    public static String getDateStr(Date date) {
        DateTime dateTime = new DateTime(date.getTime());
        return dateTime.toString(DATE_FORMATTER);
    }

    /**
     * 获取HH:mm:ss样式的字符串
     */
    public static String getTimeStr(Date date) {
        DateTime dateTime = new DateTime(date.getTime());
        return dateTime.toString(TIME_FORMATTER);
    }

    /**
     * 获取yy-MM-dd hh:mm样式的字符串
     */
    public static String getRequestTimeStr(Date date) {
        DateTime dateTime = new DateTime(date.getTime());
        return dateTime.toString(REQUEST_FORMATTER);
    }

    /**
     * 获取yy-MM-dd hh:mm样式的字符串
     */
    public static String getAdminResponseTimeStr(DateTime date) {
        return date.toString(REQUEST_FORMATTER);
    }

    /**
     * 获取HH:mm
     */
    public static String getAdminTimeStr(DateTime dateTime) {
        return dateTime.toString(RESPONSE_FORMATTER);
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss样式的字符串
     */
    public static String getStandardStr(DateTime dateTime) {
        return dateTime.toString(FULL_FORMATTER);
    }

    /**
     * 获取yyyy-MM-dd样式的字符串
     */
    public static String getDateStr(DateTime dateTime) {
        return dateTime.toString(DATE_FORMATTER);
    }

    /**
     * 获取HH:mm:ss样式的字符串
     */
    public static String getTimeStr(DateTime dateTime) {
        return dateTime.toString(TIME_FORMATTER);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss字符串转换成DateTime类型
     */
    public static DateTime convertToDateTimeByFullFormatter(String dateStr) {
        return DateTime.parse(dateStr, FULL_FORMATTER);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss字符串转换成Date型
     */
    public static Date convertToDateByFullFormatter(String dateStr) {
        DateTime dateTime = DateTime.parse(dateStr);
        return dateTime.toDate();
    }

    /**
     * Date转为DateTime
     */
    public static DateTime convertToDateTimeByDate(Date date) {
        return convertToDateTimeByFullFormatter(getDateStr(date));
    }

    /**
     * DateTime转为Date
     */
    public static Date convertToDateByDateTime(DateTime dateTime) {
        return convertToDateByFullFormatter(getDateStr(dateTime));
    }

    /**
     * 将yyyy-MM-dd HH:mm字符串转换成Date型
     */
    public static DateTime convertToDateTimeByRequestFormatter(String dateStr) {
        return DateTime.parse(dateStr, REQUEST_FORMATTER);
    }

    /**
     * 判断String 格式的时间是否正确
     */
    static public boolean isTrueFormatterTime(String time) throws ParameterException {
        try {
            convertToDateTimeByFullFormatter(time);
        } catch (Exception e) {
            LOGGER.warn("[WARN]: <isTrueFormatterTime> The time format is {}", time);
            throw new ParameterException("时间格式不正确");
        }
        return true;
    }

    /**
     * 判断时间大小
     */
    static public boolean isFromTimeMoreEarly(DateTime fromTime, DateTime toTime) throws ParameterException {
        if (getStandardStr(fromTime).compareTo(getStandardStr(toTime)) > 0) {
            LOGGER.warn("[WARN]: <isFromTimeMoreEarly> The from time {} is earlier than the to time {}",
                    fromTime.toString(), toTime.toString());
            throw new ParameterException("时间参数大小不正确");
        }
        return true;
    }

    /**
     * 获取某些days后的最后时刻
     */
    public static DateTime withTimeAtEndOfDay(int days) {
        return new DateTime().plusDays(days).withTime(Constants.TWENTY_THREE, Constants.FIFTY_NINE,
                Constants.FIFTY_NINE, Constants.NINE_NINE_NINE);
    }

    /**
     * 计算两个时间的日差
     */
    public static long getDiff2DateDays(Date date1, Date date2) {
        return Math.abs(date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24);
    }
}
