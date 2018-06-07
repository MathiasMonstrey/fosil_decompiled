package com.fossil;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;

public class aye {
    public static final int bfN = ayo.bfN;
    private static final aye bjk = new aye();

    aye() {
    }

    public static boolean m4435C(Context context, int i) {
        return ayo.m4453C(context, i);
    }

    public static aye LN() {
        return bjk;
    }

    public static void ax(Context context) {
        ayo.ax(context);
    }

    public static Intent m4436b(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !axo.at(context)) ? avd.m4593N("com.google.android.gms", m4437o(context, str)) : avd.KW();
            case 3:
                return avd.de("com.google.android.gms");
            default:
                return null;
        }
    }

    private static String m4437o(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(bfN);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(bje.aQ(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public PendingIntent mo1178a(Context context, int i, int i2) {
        return m4439a(context, i, i2, null);
    }

    public final PendingIntent m4439a(Context context, int i, int i2, String str) {
        Intent b = m4436b(context, i, str);
        return b == null ? null : PendingIntent.getActivity(context, i2, b, 268435456);
    }

    public int aj(Context context) {
        int aj = ayo.aj(context);
        return ayo.m4453C(context, aj) ? 18 : aj;
    }

    @Deprecated
    public final Intent hB(int i) {
        return m4436b(null, i, null);
    }

    public boolean hn(int i) {
        return ayo.hC(i);
    }

    public String ho(int i) {
        return ayo.ho(i);
    }
}
