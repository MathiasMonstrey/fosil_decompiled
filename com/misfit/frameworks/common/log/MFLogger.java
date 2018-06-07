package com.misfit.frameworks.common.log;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.List;

public class MFLogger {
    private static final String TAG = MFLogger.class.getSimpleName();
    private static Context appContext;
    private static boolean isDebuggable;
    private static boolean isInitialized = false;
    private static String tagPrefix;

    public static void initialize(Context context) {
        initialize(context, null);
    }

    public static void initialize(Context context, String str) {
        appContext = context.getApplicationContext();
        isInitialized = true;
        tagPrefix = TextUtils.isEmpty(str) ? "" : str + "-";
        isDebuggable = (context.getApplicationInfo().flags & 2) != 0;
        Log.d(TAG, "Inside " + TAG + ".initialize - debuggable=" + isDebuggable);
        MFFileHelper.init(context);
    }

    public static void m12672i(String str, String str2) {
        if (isDebuggable && isInitialized) {
            Log.i(tagPrefix + str, str2);
            MFFileHelper.i(appContext, tagPrefix + str, str2);
        }
    }

    public static void m12670d(String str, String str2) {
        if (isDebuggable && isInitialized) {
            Log.d(tagPrefix + str, str2);
            MFFileHelper.d(appContext, tagPrefix + str, str2);
        }
    }

    public static void m12671e(String str, String str2) {
        if (isDebuggable && isInitialized) {
            Log.e(tagPrefix + str, str2);
            MFFileHelper.e(appContext, tagPrefix + str, str2);
        }
    }

    public static void m12673v(String str, String str2) {
        if (isDebuggable && isInitialized) {
            Log.v(tagPrefix + str, str2);
            MFFileHelper.d(appContext, tagPrefix + str, str2);
        }
    }

    public static List<File> exportLogFiles() {
        return MFFileHelper.exportLogs();
    }
}
