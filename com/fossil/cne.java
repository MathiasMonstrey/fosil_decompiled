package com.fossil;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class cne {
    private static final long cyI = TimeUnit.SECONDS.toMillis(1);
    private static final long cyJ = TimeUnit.MINUTES.toMillis(1);
    private static final long cyK = TimeUnit.HOURS.toMinutes(1);
    private static final long cyL = TimeUnit.HOURS.toMillis(1);
    public static final long cyM = TimeUnit.DAYS.toMillis(1);

    public static Date getStartOfDay(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    public static int getTimezoneOffset() {
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }
}
