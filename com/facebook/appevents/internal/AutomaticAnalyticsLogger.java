package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;

class AutomaticAnalyticsLogger {
    AutomaticAnalyticsLogger() {
    }

    public static void logActivityTimeSpentEvent(Context context, String str, String str2, long j) {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        if (Utility.queryAppSettings(str, false).getAutomaticLoggingEnabled() && j > 0) {
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str2);
            newLogger.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, (double) j, bundle);
        }
    }
}
