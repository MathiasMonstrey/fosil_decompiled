package com.fossil;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

public class cnt {
    private static final String TAG = cnt.class.getSimpleName();
    private static cnt cAy;

    public static synchronized cnt adt() {
        cnt com_fossil_cnt;
        synchronized (cnt.class) {
            if (cAy == null) {
                cAy = new cnt();
            }
            com_fossil_cnt = cAy;
        }
        return com_fossil_cnt;
    }

    public void m7265b(String str, String str2, ew ewVar) {
        MFLogger.m12670d(TAG, "Inside .startNavigationFlow localAppUri=" + str + ", webUrl=" + str2);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            Toast.makeText(ewVar, "Exception, uri and url are both empty", 1).show();
            return;
        }
        int gV = gV(str2);
        if (gV == -1) {
            m7263a(ewVar, str2);
            return;
        }
        if (m7264a(jK(gV), ewVar)) {
            if (TextUtils.isEmpty(str)) {
                Intent launchIntentForPackage = PortfolioApp.ZQ().getPackageManager().getLaunchIntentForPackage(jK(gV));
                if (launchIntentForPackage != null) {
                    try {
                        ewVar.startActivity(launchIntentForPackage);
                        return;
                    } catch (Exception e) {
                        MFLogger.m12671e(TAG, "No intent to handle this action");
                    }
                } else {
                    return;
                }
            }
            MFLogger.m12670d(TAG, "Local app is found, use it to open");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setPackage(jK(gV));
            try {
                ewVar.startActivity(intent);
                return;
            } catch (Exception e2) {
                MFLogger.m12671e(TAG, "Error inside .startNavigationFlow exception=" + e2);
            }
        }
        m7263a(ewVar, str2);
    }

    private void m7263a(ew ewVar, String str) {
        try {
            MFLogger.m12670d(TAG, "No local app is found, open by webview");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            ewVar.startActivity(intent);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "Error when open web url, error=" + e);
        }
    }

    private int gV(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.contains("instagram")) {
            return 1;
        }
        if (str.contains(Constants.FACEBOOK)) {
            return 3;
        }
        if (str.contains("pinterest")) {
            return 2;
        }
        if (str.contains("tile")) {
            return 5;
        }
        return -1;
    }

    private String jK(int i) {
        switch (i) {
            case 1:
                return "com.instagram.android";
            case 2:
                return "com.pinterest";
            case 3:
                return "com.facebook.katana";
            case 5:
                return "com.thetileapp.tile";
            default:
                return "";
        }
    }

    private boolean m7264a(String str, ew ewVar) {
        try {
            ewVar.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
