package com.fossil;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

public final class dyc {
    private static C3292a dAH;
    private static C3292a dAI;
    private static final String dAJ;
    private static int level = 6;

    public interface C3292a {
        int Ov();

        void bf(String str, String str2);

        void bg(String str, String str2);

        void mo2780f(String str, String str2);

        void mo2781i(String str, String str2);
    }

    static {
        C3292a com_fossil_dyd = new dyd();
        dAH = com_fossil_dyd;
        dAI = com_fossil_dyd;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
            stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
            stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
            stringBuilder.append("] BOARD:[" + Build.BOARD);
            stringBuilder.append("] DEVICE:[" + Build.DEVICE);
            stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
            stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            stringBuilder.append("] HOST:[" + Build.HOST);
            stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            stringBuilder.append("] MODEL:[" + Build.MODEL);
            stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
            stringBuilder.append("] TAGS:[" + Build.TAGS);
            stringBuilder.append("] TYPE:[" + Build.TYPE);
            stringBuilder.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        dAJ = stringBuilder.toString();
    }

    public static void m10279a(String str, String str2, Object... objArr) {
        if (dAI != null && dAI.Ov() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            C3292a c3292a = dAI;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c3292a.mo2781i(str, format);
        }
    }

    public static void m10280d(String str, String str2) {
        if (dAI != null && dAI.Ov() <= 2) {
            C3292a c3292a = dAI;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c3292a.mo2780f(str, str2);
        }
    }

    public static void m10281e(String str, String str2) {
        if (dAI != null && dAI.Ov() <= 1) {
            if (str2 == null) {
                str2 = "";
            }
            C3292a c3292a = dAI;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c3292a.bf(str, str2);
        }
    }

    public static void m10282x(String str, String str2) {
        m10279a(str, str2, null);
    }

    public static void m10283y(String str, String str2) {
        if (dAI != null && dAI.Ov() <= 3) {
            C3292a c3292a = dAI;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c3292a.bg(str, str2);
        }
    }
}
