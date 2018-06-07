package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.facebook.appevents.AppEventsConstants;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

public class cnf {
    private static final String TAG = cnf.class.getSimpleName();

    public static int jC(int i) {
        return i / 60;
    }

    public static int jD(int i) {
        return i - (jC(i) * 60);
    }

    public static String m7188G(Context context, int i) {
        int i2 = i / 60;
        int i3 = i - (i2 * 60);
        context.getResources();
        return String.valueOf(i2) + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Time_Abbreviations_Hour_H) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + String.valueOf(i3) + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Time_Abbreviations_Minute_M);
    }

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

    public static long go(String str) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".getDateTimeFormYYYYMMDD - yymmdd=" + str + ", DateTime=" + new Date().getTime());
        long j = 0;
        try {
            j = new DateTime(new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(str)).getMillis();
        } catch (ParseException e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "Error Inside " + TAG + ".getDateTimeFormYYYYMMDD - yymmdd=" + str);
        }
        return j;
    }

    public static long gp(String str) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".convertFromStringToLongTime - yymmdd=" + str + ", DateTime=" + new Date().getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        try {
            timeInMillis = new DateTime(simpleDateFormat.parse(str)).getMillis();
        } catch (ParseException e) {
            e.printStackTrace();
            MFLogger.m12671e(TAG, "Error Inside " + TAG + ".convertFromStringToLongTime - yymmdd=" + str);
        }
        return timeInMillis;
    }

    public static String aF(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date(j));
    }

    public static String getStringCurrentTimeYYYYMMDD() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
    }

    public static int jE(int i) {
        return i * 30;
    }

    static String m7189a(int i, Context context) {
        int i2;
        int i3;
        String str;
        int i4 = i / 60;
        int i5 = i - (i4 * 60);
        boolean is24HourFormat = DateFormat.is24HourFormat(context);
        if (is24HourFormat) {
            if (i4 > 24) {
                i2 = 24;
                i3 = i4 - 24;
            } else {
                i2 = 24;
                i3 = i4;
            }
        } else if (i4 == 0) {
            i3 = 12;
            i2 = 12;
        } else if (i4 > 12) {
            i3 = i4 - 12;
            i2 = 12;
        } else {
            i3 = i4;
            i2 = 12;
        }
        if (i5 == 0) {
            str = "00";
        } else if (i5 < 10) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO + i5;
        } else {
            str = "" + i5;
        }
        str = i3 + ":" + str;
        if (!is24HourFormat) {
            return str;
        }
        if (i4 < i2) {
            return str + arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Alarm_Text_AM);
        }
        return str + arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Alarm_Text_PM);
    }

    public static int getTimezoneRawOffsetById(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1024;
        }
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (!timeZone.inDaylightTime(Calendar.getInstance().getTime())) {
            return timeZone.getRawOffset() / DateTimeConstants.MILLIS_PER_MINUTE;
        }
        return (timeZone.getDSTSavings() + timeZone.getRawOffset()) / DateTimeConstants.MILLIS_PER_MINUTE;
    }
}
