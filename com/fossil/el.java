package com.fossil;

import android.content.Context;
import android.os.Build.VERSION;

public final class el {
    private static final C3443b HT;

    static class C3443b {
        C3443b() {
        }

        public String permissionToOp(String str) {
            return null;
        }

        public int mo2941a(Context context, String str, String str2) {
            return 1;
        }
    }

    static class C3444a extends C3443b {
        C3444a() {
        }

        public String permissionToOp(String str) {
            return em.permissionToOp(str);
        }

        public int mo2941a(Context context, String str, String str2) {
            return em.m10871a(context, str, str2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            HT = new C3444a();
        } else {
            HT = new C3443b();
        }
    }

    public static String permissionToOp(String str) {
        return HT.permissionToOp(str);
    }

    public static int m10848a(Context context, String str, String str2) {
        return HT.mo2941a(context, str, str2);
    }
}
