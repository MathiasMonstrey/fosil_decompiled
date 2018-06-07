package com.misfit.ble.util;

import android.util.Log;
import com.misfit.ble.obfuscated.C4592s;

public class LogUtils {

    public enum LogLevel {
        NONE(0),
        VERBOSE(1),
        DEBUG(2),
        INFO(3),
        WARN(4),
        ERROR(5);
        
        private final int id;

        private LogLevel(int i) {
            this.id = i;
        }

        int getId() {
            return this.id;
        }
    }

    public static String m15473M(String str) {
        if (str.length() > 23 - "mf_".length()) {
            return "mf_" + str.substring(0, (23 - "mf_".length()) - 1);
        }
        return "mf_" + str;
    }

    public static String m15475b(Class cls) {
        return m15473M(cls.getSimpleName());
    }

    public static void m15476d(String str, String str2) {
        int length = 4073 - str.length();
        for (int i = 0; i <= str2.length() / length; i++) {
            int i2 = i * length;
            int i3 = (i + 1) * length;
            if (i3 > str2.length()) {
                i3 = str2.length();
            }
            if (m15474a(LogLevel.DEBUG)) {
                Log.d(str, str2.substring(i2, i3));
            }
        }
    }

    public static void m15478k(String str, String str2) {
        int length = 4073 - str.length();
        for (int i = 0; i <= str2.length() / length; i++) {
            int i2 = i * length;
            int i3 = (i + 1) * length;
            if (i3 > str2.length()) {
                i3 = str2.length();
            }
            if (m15474a(LogLevel.INFO)) {
                Log.i(str, str2.substring(i2, i3));
            }
        }
    }

    public static void m15479l(String str, String str2) {
        int length = 4073 - str.length();
        for (int i = 0; i <= str2.length() / length; i++) {
            int i2 = i * length;
            int i3 = (i + 1) * length;
            if (i3 > str2.length()) {
                i3 = str2.length();
            }
            if (m15474a(LogLevel.WARN)) {
                Log.w(str, str2.substring(i2, i3));
            }
        }
    }

    public static void m15477e(String str, String str2) {
        int length = 4073 - str.length();
        for (int i = 0; i <= str2.length() / length; i++) {
            int i2 = i * length;
            int i3 = (i + 1) * length;
            if (i3 > str2.length()) {
                i3 = str2.length();
            }
            if (m15474a(LogLevel.ERROR)) {
                Log.e(str, str2.substring(i2, i3));
            }
        }
    }

    private static boolean m15474a(LogLevel logLevel) {
        return C4592s.m15229y() != LogLevel.NONE && logLevel.getId() >= C4592s.m15229y().getId();
    }
}
