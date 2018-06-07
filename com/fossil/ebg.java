package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class ebg {
    private static SharedPreferences dDe = null;

    public static long m10443a(Context context, String str, long j) {
        return ec(context).getLong(ebb.m10435Y(context, "wxop_" + str), j);
    }

    public static void m10444b(Context context, String str, long j) {
        String Y = ebb.m10435Y(context, "wxop_" + str);
        Editor edit = ec(context).edit();
        edit.putLong(Y, j);
        edit.commit();
    }

    public static int m10445d(Context context, String str, int i) {
        return ec(context).getInt(ebb.m10435Y(context, "wxop_" + str), i);
    }

    public static void m10446e(Context context, String str, int i) {
        String Y = ebb.m10435Y(context, "wxop_" + str);
        Editor edit = ec(context).edit();
        edit.putInt(Y, i);
        edit.commit();
    }

    static synchronized SharedPreferences ec(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (ebg.class) {
            sharedPreferences = context.getSharedPreferences(".mta-wxop", 0);
            dDe = sharedPreferences;
            if (sharedPreferences == null) {
                dDe = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = dDe;
        }
        return sharedPreferences;
    }

    public static String m10447l(Context context, String str, String str2) {
        return ec(context).getString(ebb.m10435Y(context, "wxop_" + str), str2);
    }

    public static void m10448m(Context context, String str, String str2) {
        String Y = ebb.m10435Y(context, "wxop_" + str);
        Editor edit = ec(context).edit();
        edit.putString(Y, str2);
        edit.commit();
    }
}
