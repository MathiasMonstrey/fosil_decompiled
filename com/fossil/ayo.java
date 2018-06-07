package com.fossil;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.fossil.arv.C1875c;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayo {
    @Deprecated
    public static final int bfN = 11020000;
    static final AtomicBoolean bjA = new AtomicBoolean();
    private static final AtomicBoolean bjB = new AtomicBoolean();
    private static boolean bjw = false;
    private static boolean bjx = false;
    private static boolean bjy = false;
    private static boolean bjz = false;

    ayo() {
    }

    @Deprecated
    public static boolean m4452B(Context context, int i) {
        return axz.m4689B(context, i);
    }

    @Deprecated
    public static boolean m4453C(Context context, int i) {
        return i == 18 ? true : i == 1 ? m4455p(context, "com.google.android.gms") : false;
    }

    @TargetApi(19)
    @Deprecated
    public static boolean m4454a(Context context, int i, String str) {
        return axz.m4690a(context, i, str);
    }

    @Deprecated
    public static int aj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C1875c.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!("com.google.android.gms".equals(context.getPackageName()) || bjB.get())) {
            int ap = avw.ap(context);
            if (ap == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (ap != bfN) {
                int i = bfN;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(ap).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
        int i2 = (axo.at(context) || axo.av(context)) ? 0 : 1;
        PackageInfo packageInfo = null;
        if (i2 != 0) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            ayp.aA(context);
            if (i2 != 0) {
                if (ayp.m4698a(packageInfo, ayj.bjs) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (ayp.m4698a(packageInfo2, ayp.m4698a(packageInfo, ayj.bjs)) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (ayp.m4698a(packageInfo2, ayj.bjs) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (packageInfo2.versionCode / 1000 < bfN / 1000) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + bfN + " but found " + packageInfo2.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    public static Resources al(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Context am(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static void ax(Context context) {
        if (!bjA.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException e) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean az(android.content.Context r7) {
        /*
        r0 = 0;
        r1 = 1;
        r2 = bjz;
        if (r2 != 0) goto L_0x002d;
    L_0x0006:
        r2 = com.fossil.bje.aQ(r7);	 Catch:{ NameNotFoundException -> 0x0041 }
        r3 = "com.google.android.gms";
        r4 = 64;
        r2 = r2.getPackageInfo(r3, r4);	 Catch:{ NameNotFoundException -> 0x0041 }
        if (r2 == 0) goto L_0x003d;
    L_0x0014:
        com.fossil.ayp.aA(r7);	 Catch:{ NameNotFoundException -> 0x0041 }
        r3 = 1;
        r3 = new com.fossil.ayg[r3];	 Catch:{ NameNotFoundException -> 0x0041 }
        r4 = 0;
        r5 = com.fossil.ayj.bjs;	 Catch:{ NameNotFoundException -> 0x0041 }
        r6 = 1;
        r5 = r5[r6];	 Catch:{ NameNotFoundException -> 0x0041 }
        r3[r4] = r5;	 Catch:{ NameNotFoundException -> 0x0041 }
        r2 = com.fossil.ayp.m4698a(r2, r3);	 Catch:{ NameNotFoundException -> 0x0041 }
        if (r2 == 0) goto L_0x003d;
    L_0x0028:
        r2 = 1;
        bjy = r2;	 Catch:{ NameNotFoundException -> 0x0041 }
    L_0x002b:
        bjz = r1;
    L_0x002d:
        r2 = bjy;
        if (r2 != 0) goto L_0x003b;
    L_0x0031:
        r2 = "user";
        r3 = android.os.Build.TYPE;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x003c;
    L_0x003b:
        r0 = r1;
    L_0x003c:
        return r0;
    L_0x003d:
        r2 = 0;
        bjy = r2;	 Catch:{ NameNotFoundException -> 0x0041 }
        goto L_0x002b;
    L_0x0041:
        r2 = move-exception;
        r3 = "GooglePlayServicesUtil";
        r4 = "Cannot find Google Play services package name.";
        android.util.Log.w(r3, r4, r2);	 Catch:{ all -> 0x004c }
        bjz = r1;
        goto L_0x002d;
    L_0x004c:
        r0 = move-exception;
        bjz = r1;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ayo.az(android.content.Context):boolean");
    }

    @Deprecated
    public static boolean hC(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static String ho(int i) {
        return atn.hm(i);
    }

    @TargetApi(21)
    static boolean m4455p(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (axt.LJ()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled) {
                Object obj;
                if (axt.LG()) {
                    Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
                    if (applicationRestrictions != null && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(applicationRestrictions.getString("restricted_profile"))) {
                        obj = 1;
                        if (obj == null) {
                            return true;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
