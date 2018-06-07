package com.fossil;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.Arrays;
import java.util.HashMap;

public class cnp {
    private static final String TAG = cnp.class.getSimpleName();
    private static cnp czE;

    public static synchronized cnp acc() {
        cnp com_fossil_cnp;
        synchronized (cnp.class) {
            if (czE == null) {
                czE = new cnp();
            }
            com_fossil_cnp = czE;
        }
        return com_fossil_cnp;
    }

    public void m7227a(String str, String str2, ew ewVar) {
        MFLogger.m12670d(TAG, "Inside .startNavigation with internalUri=" + str + ", webUrl=" + str2);
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str) || !str.contains("fossilq://")) {
                cnt.adt().m7265b(str, str2, ewVar);
                return;
            }
            try {
                ewVar.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "Error inside .startNavigationFlow exception=" + e);
            }
        }
    }

    public void gu(String str) {
        Intent intent = new Intent("BROADCAST_INTERNAL_NAVIGATION");
        intent.putExtra("uri", str);
        gy.m11536p(PortfolioApp.ZQ()).m11538b(intent);
    }

    public HashMap<String, String> gv(String str) {
        HashMap<String, String> hashMap = null;
        String[] split = str.split("://");
        if (split == null || split.length < 1) {
            MFLogger.m12671e(TAG, "Inside .buildTag returning components=" + Arrays.toString(split));
        } else {
            split = split[1].split("/");
            if (split == null || split.length <= 0) {
                MFLogger.m12671e(TAG, "Inside .buildTag returning details=" + Arrays.toString(split));
            } else {
                hashMap = new HashMap();
                hashMap.put("component", split[0]);
                if (split.length > 1) {
                    String[] split2 = split[1].split("&");
                    if (split2 != null && split2.length > 0) {
                        for (String split3 : split2) {
                            String[] split4 = split3.split(SimpleComparison.EQUAL_TO_OPERATION);
                            if (split4 != null && split4.length == 2) {
                                hashMap.put(split4[0], split4[1]);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }
}
