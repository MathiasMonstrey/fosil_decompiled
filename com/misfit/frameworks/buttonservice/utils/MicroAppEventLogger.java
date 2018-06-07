package com.misfit.frameworks.buttonservice.utils;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MicroAppEventLogger {
    private static final String LOG_NAME = "micro_app_event";
    private static final String TAG = MicroAppEventLogger.class.getSimpleName();
    private static boolean isDebuggable;
    private static boolean isInitialized = false;
    private static MicroAppFileHelper microAppFileHelper;

    public static boolean isInitialized() {
        return isInitialized;
    }

    public static void initialize(Context context) {
        boolean z = true;
        Context applicationContext = context.getApplicationContext();
        isInitialized = true;
        if ((context.getApplicationInfo().flags & 2) == 0) {
            z = false;
        }
        isDebuggable = z;
        Log.d(TAG, "Inside " + TAG + ".initialize - debuggable=" + isDebuggable);
        microAppFileHelper = new MicroAppFileHelper(applicationContext, LOG_NAME);
    }

    public static void log(String str, String str2, String str3, String str4) {
        if (isDebuggable && isInitialized) {
            microAppFileHelper.log(str, str2, str3, str4);
        }
    }

    public static List<File> exportLogFiles() {
        if (isDebuggable && isInitialized) {
            return MicroAppFileHelper.access$000(microAppFileHelper);
        }
        return new ArrayList();
    }

    public static void resetLogFiles() {
        if (isDebuggable && isInitialized) {
            MicroAppFileHelper.access$100(microAppFileHelper);
        }
    }
}
