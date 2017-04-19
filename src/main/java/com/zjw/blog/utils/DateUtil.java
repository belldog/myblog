package com.zjw.blog.utils;


import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 获取当前时间与公元1970。。。之间的毫秒数
     *
     * @return
     */
    public static long getCurrentDateTimeAsLong() {
        //Calendar表示日历，是个抽象类，通过静态方法获取他的实例，当前日期
        Calendar dateTime = Calendar.getInstance();
        //返回该日期与公元1970年之间相差的毫秒数
        return dateTime.getTimeInMillis();
    }

    /**
     * 取得当前时间的yyyy-MM-dd格式的字符串，如“2017-3-20”
     *
     * @return
     */
    public static String getCurrentDateString() {
        return getCurrentDateString("yyyy-MM-dd");
    }

    /**
     * 获取当前时间的某种格式的字符串
     *
     * @param pattern
     * @return
     */
    public static String getCurrentDateString(String pattern) {
        //获取当前日历
        Calendar dateTime = Calendar.getInstance();
        //Calendar的getTime()方法返回的是Date,这一步是把Date格式化成某种字符串
        return format(dateTime.getTime(), pattern);
    }

    /**
     * 获取当前时间的某种格式的字符串，跟上一个方法没有任何区别
     *
     * @param pattern
     * @return
     */
    public static String getCurrentDateTimeString(String pattern) {
        Calendar dateTime = Calendar.getInstance();
        return format(dateTime.getTime(), pattern);
    }

    /**
     * 取得当前时间的yyyy-MM-dd  HH:mm:ss格式的字符串，如“2017-03-20 23:35:44”
     *
     * @return
     */
    public static String getCurrentDateTimeString() {
        return getCurrentDateTimeString("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取代表当前时间的Date,有年月日，时分秒
     *
     * @return
     */
    public static Date getCurrentDateTime() {
        Calendar dateTime = Calendar.getInstance();
        return dateTime.getTime();
    }

    /**
     * 获取代表当前时间的Date,只有年月日
     *
     * @return
     */
    public static Date getCurrentDate() {
        return parseDate(getCurrentDateString(), "yyyy-MM-dd");
    }

    /**
     * 把日期按照某种正则转成某种格式的字符串
     *
     * @param targetDate
     * @param pattern
     * @return
     */
    public static String format(Date targetDate, String pattern) {
        if (null == targetDate) {
            return "";
        }
        DateFormat dateFormater = new SimpleDateFormat(pattern);
        return dateFormater.format(targetDate);
    }

    /**
     * 把某个字符串按照某种正则装成日期Date
     *
     * @param dateString
     * @param pattern
     * @return
     */
    public static Date parseDate(String dateString, String pattern) {
        try {
            DateFormat dateFormater = new SimpleDateFormat(pattern);
            return dateFormater.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 把字符串严格解析成Date
     *
     * @param dateString
     * @return
     */
    public static Date parseDate(String dateString) {
        String[] pattern = new String[]{"yyyy-MM", "yyyyMM", "yyyy/MM", "yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd",
                "yyyy-MM-dd HH:mm", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss"};
        try {
            //注意这里是DateUtils,不是DateUtil,大概的意思是依次根据上面的格式来严格解析该字符串
            //知道返回一个Date对象
            return DateUtils.parseDate(dateString, pattern);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断两个Date之间相隔了几天
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long diffDays(Date beginDate, Date endDate) {
        if (null == endDate || beginDate == null) {
            return -1;
        }
        long l = beginDate.getTime() - endDate.getTime();
        long day = l / (24 * 60 * 60 * 1000);

        return day;
    }

    /**
     * 获取某天的开始时间Date如2017年3月20日 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getStartDateTime(Object date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date.toString()));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天的结束时间Date如2017年3月20日 23:59:59
     *
     * @param date
     * @return
     */
    public static Date getEndDateTime(Object date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date.toString()));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取昨天的开始时间Date如2017年3月19日 00:00:00
     *
     * @return
     */
    public static Date getYesterdayBeginDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取昨天的结束时间Date如2017年3月19日 23:59:59
     *
     * @return
     */
    public static Date getYesterdayEndDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取前天的开始时间Date,如2017年3月18日 00:00:00
     *
     * @return
     */
    public static Date getTheDayBeforeYesterdayBeginDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -2);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取今天的结束时间Date如2017年3月20日 23:59:59
     *
     * @return
     */
    public static Date getCurrentEndDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取明天的开始时间Date如2017年3月21日 00:00:00
     *
     * @return
     */
    public static Date getTomorrowBeginDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

}
