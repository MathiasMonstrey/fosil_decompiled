package com.fossil.wearables.fsl.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtils {
    private static final String SIMPLE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    private static final String TAG = TimeUtils.class.getSimpleName();

    public static Date getStartOfDay(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        return instance.getTime();
    }

    public static int getTimezoneOffset() {
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    public static String getStringCurrentTimeYYYYMMDD() {
        return new SimpleDateFormat(SIMPLE_FORMAT_YYYY_MM_DD, Locale.US).format(new Date());
    }

    public static String getStringTimeYYYYMMDD(long j) {
        return new SimpleDateFormat(SIMPLE_FORMAT_YYYY_MM_DD, Locale.US).format(new Date(j));
    }
}
