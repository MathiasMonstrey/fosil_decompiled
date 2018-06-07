package com.fossil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.fossil.aqq.C1543a;

public class aov implements C1543a {
    private static final String aWB = aov.class.getSimpleName();
    private static aov bap;
    private String aWS;
    private String f1434d;

    private aov() {
        aqq Jf = aqp.Jf();
        this.aWS = (String) Jf.cw("VersionName");
        Jf.m4241a("VersionName", (C1543a) this);
        app.m4180g(4, aWB, "initSettings, VersionName = " + this.aWS);
    }

    public static synchronized aov IF() {
        aov com_fossil_aov;
        synchronized (aov.class) {
            if (bap == null) {
                bap = new aov();
            }
            com_fossil_aov = bap;
        }
        return com_fossil_aov;
    }

    public static String HI() {
        return VERSION.RELEASE;
    }

    public static String Ih() {
        return Build.DEVICE;
    }

    public final synchronized String Iw() {
        String str;
        if (!TextUtils.isEmpty(this.aWS)) {
            str = this.aWS;
        } else if (TextUtils.isEmpty(this.f1434d)) {
            this.f1434d = m4128h();
            str = this.f1434d;
        } else {
            str = this.f1434d;
        }
        return str;
    }

    private static String m4128h() {
        try {
            Context context = apc.IO().baD;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionName != null) {
                return packageInfo.versionName;
            }
            if (packageInfo.versionCode != 0) {
                return Integer.toString(packageInfo.versionCode);
            }
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        } catch (Throwable th) {
            app.m4174b(6, aWB, "", th);
        }
    }

    public final void mo761a(String str, Object obj) {
        if (str.equals("VersionName")) {
            this.aWS = (String) obj;
            app.m4180g(4, aWB, "onSettingUpdate, VersionName = " + this.aWS);
            return;
        }
        app.m4180g(6, aWB, "onSettingUpdate internal error!");
    }
}
