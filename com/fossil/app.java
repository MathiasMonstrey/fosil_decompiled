package com.fossil;

import android.text.TextUtils;
import android.util.Log;

public final class app {
    private static boolean aWM = false;
    private static boolean aXk = false;
    private static int f1446b = 5;

    public static void HJ() {
        aXk = true;
    }

    public static void HO() {
        aXk = false;
    }

    public static int HF() {
        return f1446b;
    }

    public static void m4172a(int i) {
        f1446b = i;
    }

    public static boolean IY() {
        return aWM;
    }

    private static void m4173a(int i, String str, String str2, Throwable th) {
        m4176d(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    private static void m4176d(int i, String str, String str2) {
        if (!aXk && f1446b <= i) {
            m4177e(i, str, str2);
        }
    }

    private static void m4177e(int i, String str, String str2) {
        if (!aWM) {
            str = "FlurryAgent";
        }
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = 4000 > length - i2 ? length : i2 + 4000;
            if (Log.println(i, str, str2.substring(i2, i3)) > 0) {
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public static void m4181w(String str, String str2) {
        m4176d(3, str, str2);
    }

    public static void m4175b(String str, String str2, Throwable th) {
        m4173a(6, str, str2, th);
    }

    public static void m4182x(String str, String str2) {
        m4176d(6, str, str2);
    }

    public static void m4183y(String str, String str2) {
        m4176d(4, str, str2);
    }

    public static void m4178e(String str, String str2) {
        m4176d(5, str, str2);
    }

    private static void m4179f(int i, String str, String str2) {
        if (aWM) {
            m4177e(i, str, str2);
        }
    }

    public static void m4180g(int i, String str, String str2) {
        m4179f(i, str, str2);
    }

    public static void m4174b(int i, String str, String str2, Throwable th) {
        m4179f(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }
}
