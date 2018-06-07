package com.misfit.frameworks.network.utils;

import com.misfit.frameworks.common.log.MFLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
    private static final String TAG = DateTimeUtil.class.getSimpleName();
    private static final String UTC_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static Date parseUTCDateTime(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).parse(str);
        } catch (Exception e) {
            MFLogger.e(TAG, "Error inside " + TAG + ".parseUTCDateTime - e=" + e);
            return null;
        }
    }

    public static int compare(Date date, Date date2) {
        if (date == null) {
            return 1;
        }
        if (date2 == null) {
            return -1;
        }
        if (date.after(date2)) {
            return -1;
        }
        if (date.before(date2)) {
            return 1;
        }
        return 0;
    }
}
