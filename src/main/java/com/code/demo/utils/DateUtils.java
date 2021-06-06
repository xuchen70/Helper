package com.code.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_TIME = "HH:mm:ss";
    public static final String PATTERN_DATE_ALL = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentDate() {
        return formatDate(PATTERN_DATE,new Date());
    }

    public static String getCurrentTime() {
        return formatDate(PATTERN_TIME,new Date());
    }

    public static String getCurrentDateAll() {
        return formatDate(PATTERN_DATE_ALL,new Date());
    }

    public static String formatDate(String pattern,Date date){
        if (StringUtils.isEmpty(pattern)) pattern = "yyyy-MM-dd HH:mm:ss";
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
