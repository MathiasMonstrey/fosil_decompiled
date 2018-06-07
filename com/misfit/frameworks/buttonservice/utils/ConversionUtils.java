package com.misfit.frameworks.buttonservice.utils;

import android.text.TextUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.joda.time.DateTimeConstants;

public class ConversionUtils {
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
