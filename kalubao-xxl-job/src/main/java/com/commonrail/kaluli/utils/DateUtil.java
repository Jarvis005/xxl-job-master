package com.commonrail.kaluli.utils;

import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 */
public final class DateUtil {
    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static final String FORMAT_SHORT    = "yyyy-MM-dd";
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    public static final String FORMAT_LONG     = "yyyy-MM-dd HH:mm:ss";
    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    public static final String FORMAT_FULL     = "yyyy-MM-dd HH:mm:ss.S";
    /**
     * 中文简写 如：2010年12月01日
     */
    public static final String FORMAT_SHORT_CN = "yyyy年MM月dd";
    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    public static final String FORMAT_LONG_CN  = "yyyy年MM月dd日  HH时mm分ss秒";
    /**
     * 精确到毫秒的完整中文时间
     */
    public static final String FORMAT_FULL_CN  = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";
    /**
     * 一天的开始
     */
    public static final String DAY_START       = " 00:00:00";
    /**
     * 一天的结束
     */
    public static final String DAY_END         = " 23:59:59";

    public static final List<String> patterns;

    static {
        patterns = new ArrayList<String>() {{
            add(FORMAT_FULL);
            add(FORMAT_LONG);
            add("yyyy-MM-dd HH:mm");
            add("yyyy-MM-dd HH");
            add(FORMAT_SHORT);
        }};
    }

    /**
     * 获得默认的 date pattern
     */
    public static String getDatePattern() {
        return FORMAT_LONG;
    }

    /**
     * 根据预设格式返回当前日期
     *
     * @return
     */
    public static String getNow() {
        return format(new Date());
    }

    /**
     * 获取当天开始时间
     *
     * @return
     */
    public static Date getDayStart(Date date) {
        return parse(format(date, FORMAT_SHORT) + DAY_START);
    }

    /**
     * 获取当天结束时间
     *
     * @return
     */
    public static Date getDayEnd(Date date) {
        return parse(format(date, FORMAT_SHORT) + DAY_END);
    }

    /**
     * 获取今天开始时间
     *
     * @return
     */
    public static Date getTodayStart() {
        return parse(getNow(DateUtil.FORMAT_SHORT) + DAY_START);
    }

    /**
     * 获取今天结束时间
     *
     * @return
     */
    public static Date getTodayEnd() {
        return parse(getNow(DateUtil.FORMAT_SHORT) + DAY_END);
    }

    /**
     * 根据用户格式返回当前日期
     *
     * @param format
     * @return
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }

    /**
     * 使用预设格式格式化日期
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, getDatePattern());
    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return returnValue;
    }

    /**
     * 使用预设格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @return
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 转换合适的格式的日期
     *
     * @param text
     * @return
     */
    public static Date tryConvert(String text) {
        if (text == null) {
            return null;
        }
        for (String pattern : patterns) {
            Date date = tryConvert(text, pattern);
            if (date != null) {
                return date;
            }
        }

        return null;
    }

    /**
     * @param text
     * @param pattern
     * @return
     */
    public static Date tryConvert(String text, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(text);
        } catch (ParseException ex) {
        }

        return null;
    }

    /**
     * 在日期上增加数个整年
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return
     */
    public static Date addYear(Date date, int n) {
        return dateAdd(date, Calendar.YEAR, n);
    }

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return
     */
    public static Date addMonth(Date date, int n) {
        return dateAdd(date, Calendar.MONTH, n);
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return
     */
    public static Date addDay(Date date, int n) {
        return dateAdd(date, Calendar.DATE, n);
    }

    /**
     * 在日期上增加小时
     *
     * @param n
     * @return
     */
    public static Date addHour(Date date, int n) {
        return dateAdd(date, Calendar.HOUR, n);
    }

    /**
     * 在日期上增加分钟
     *
     * @param n
     * @return
     */
    public static Date addMinute(Date date, int n) {
        return dateAdd(date, Calendar.MINUTE, n);
    }

    /**
     * 在日期上增加秒
     *
     * @param n
     * @return
     */
    public static Date addSecond(Date date, int n) {
        return dateAdd(date, Calendar.SECOND, n);
    }

    /**
     * @param date
     * @param t
     * @param n
     * @return
     */
    public static Date dateAdd(Date date, int t, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(t, n);
        return cal.getTime();
    }

    /**
     * 计算两个日期相差秒数的绝对值
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long absDiffSec(Date date1, Date date2) {
        return Math.abs(dateDiff(date1, date2) / 1000);
    }

    /**
     * 计算两个日期相差秒数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long dateDiff(Date date1, Date date2) {
        Assert.notNull(date1, "date1 must not be null");
        Assert.notNull(date2, "date2 must not be null");
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_LONG);
        try {
            date1 = sdf.parse(sdf.format(date1));
            date2 = sdf.parse(sdf.format(date2));
            return (date1.getTime() - date2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 计算两个日期相差秒数的绝对值
     *
     * @param date1Str
     * @param date2Str
     * @return
     */
    public static long absDiffSec(String date1Str, String date2Str) {
        return Math.abs(dateDiff(date1Str, date2Str) / 1000);
    }

    /**
     * 计算两个日期相差秒数
     *
     * @param date1Str
     * @param date2Str
     * @return
     */
    public static long dateDiff(String date1Str, String date2Str) {
        Assert.notNull(date1Str, "date1Str must not be null");
        Assert.notNull(date2Str, "date2Str must not be null");
        Date date1 = tryConvert(date1Str);
        Date date2 = tryConvert(date2Str);
        return (date1.getTime() - date2.getTime());
    }

    public static <T> String showDateDiff(T date1, T date2) {
        Assert.notNull(date1, "date1 must not be null");
        Assert.notNull(date2, "date2 must not be null");
        long differ;
        if (date1 instanceof String) {
            differ = absDiffSec((String) date1, (String) date2);
        } else if (date1 instanceof Date) {
            differ = absDiffSec((Date) date1, (Date) date2);
        } else {
            throw new IllegalStateException("param not is a String or Date");
        }

        return showDateDiff(differ);
    }

    public static String showDateDiff(long differ) {
        StringBuffer differStr = new StringBuffer();
        if (differ < 60) {
            differStr.append(differ).append("秒");
        } else if (differ < 3600) {
            differStr.append(differ / 60).append("分").append(differ % 60).append("秒");
        } else if (differ < 86400) {
            differStr.append(differ / 3600).append("小时").append(differ % 3600 / 60).append("分").append(differ % 3600 % 60).append("秒");
        } else {
            differStr.append(differ / 86400).append("天").append(differ % 86400 / 3600).append("小时").append(differ % 86400 % 3600 / 60).append("分").append(differ % 86400 % 3600 % 60).append("秒");
        }

        return differStr.toString();
    }

    public static String showDateToM(long differ) {
        StringBuffer differStr = new StringBuffer();
        if (differ < 60) {
            differStr.append("1分");
        } else if (differ < 3600) {
            differStr.append(differ / 60).append("分");
        } else if (differ < 86400) {
            differStr.append(differ / 3600).append("小时").append(differ % 3600 / 60).append("分");
        } else {
            differStr.append(differ / 86400).append("天").append(differ % 86400 / 3600).append("小时").append(differ % 86400 % 3600 / 60).append("分");
        }

        return differStr.toString();
    }

    /**
     * 获取时间戳
     */
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    /**
     * 获取日期年份
     *
     * @param date 日期
     * @return
     */
    public static String getYear(Date date) {
        return format(date).substring(0, 4);
    }

    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return
     */
    public static int countDays(String date) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return
     */
    public static int countDays(String date, String format) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, format));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

}