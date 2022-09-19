package com.wuying.api.threadLocal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static Date parse(String dateString) {
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static String formateDateTime(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");
        return sf.format(date);
    }
}
