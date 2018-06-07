package com.fossil;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.regex.Pattern;

public class dri {
    private static final Pattern dfq = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);

    public static String ju(String str) {
        if (!(TextUtils.isEmpty(str) || str.contains("+"))) {
            TelephonyManager telephonyManager = (TelephonyManager) PortfolioApp.ZQ().getSystemService("phone");
            PhoneNumberUtil Xx = PhoneNumberUtil.Xx();
            if (telephonyManager != null) {
                try {
                    str = Xx.a(Xx.am(str, telephonyManager.getNetworkCountryIso().toUpperCase()), PhoneNumberFormat.INTERNATIONAL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    public static boolean m9479a(String str, String str2, boolean z, boolean z2) {
        boolean z3 = false;
        if (VERSION.SDK_INT >= 23) {
            int i;
            boolean z4;
            if (z) {
                i = 8;
            } else {
                i = 4;
            }
            NotificationManager notificationManager = (NotificationManager) PortfolioApp.ZQ().getSystemService("notification");
            if (notificationManager != null) {
                int currentInterruptionFilter = notificationManager.getCurrentInterruptionFilter();
                if (currentInterruptionFilter == 3) {
                    MFLogger.m12670d(str, "Block due to full silence do not disturb");
                    z4 = true;
                } else if (currentInterruptionFilter == 4) {
                    MFLogger.m12670d(str, "Block due to alarm do not disturb");
                    z4 = true;
                } else if (currentInterruptionFilter == 2) {
                    if (!notificationManager.isNotificationPolicyAccessGranted()) {
                        return true;
                    }
                    if ((i & notificationManager.getNotificationPolicy().priorityCategories) != 0) {
                        if (z) {
                            i = notificationManager.getNotificationPolicy().priorityCallSenders;
                        } else {
                            i = notificationManager.getNotificationPolicy().priorityMessageSenders;
                        }
                        if (i == 2) {
                            cpd acB = cnq.acd().acB();
                            if (!(acB == null || TextUtils.isEmpty(str2) || acB.ht(str2) || (z && z2 && (notificationManager.getNotificationPolicy().priorityCategories & 16) != 0))) {
                                MFLogger.m12670d(str, "Block due to not matches favorites contact");
                                z4 = true;
                            }
                        }
                    } else if (!(z && z2 && (notificationManager.getNotificationPolicy().priorityCategories & 16) != 0)) {
                        MFLogger.m12670d(str, "Block due to full priority do not disturb");
                        z4 = true;
                    }
                }
                z3 = z4;
            }
            z4 = false;
            z3 = z4;
        } else {
            try {
                AudioManager audioManager = (AudioManager) PortfolioApp.ZQ().getSystemService("audio");
                if (audioManager != null && audioManager.getRingerMode() == 0) {
                    MFLogger.m12670d(str, "Block due to silent mode on");
                    z3 = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z3;
    }

    public static float at(float f) {
        return Resources.getSystem().getDisplayMetrics().density * f;
    }

    public static int m9478a(float f, Context context) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static float m9480b(int i, Context context) {
        return ((float) i) * context.getResources().getDisplayMetrics().density;
    }

    public static void cX(final View view) {
        if (view != null) {
            view.setEnabled(false);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    view.setEnabled(true);
                }
            }, 500);
        }
    }
}
