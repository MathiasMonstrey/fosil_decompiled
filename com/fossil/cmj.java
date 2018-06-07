package com.fossil;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import java.util.Map;
import java.util.Map.Entry;

public class cmj {
    private static final String TAG = cmj.class.getSimpleName();
    private static FirebaseAnalytics cxA;
    private static cmj cxB;

    private cmj(Context context) {
        cxA = FirebaseAnalytics.getInstance(context);
    }

    public static synchronized cmj bs(Context context) {
        cmj com_fossil_cmj;
        synchronized (cmj.class) {
            if (cxB == null) {
                cxB = new cmj(context);
            }
            com_fossil_cmj = cxB;
        }
        return com_fossil_cmj;
    }

    public void bQ(boolean z) {
        MFUser currentUser = cnq.acd().ace().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUserId();
            currentUser.setDiagnosticEnabled(z);
            MFLogger.m12670d(TAG, "Inside " + TAG + ".setAnalyticEnable - userId = " + userId + ", enable=" + z);
            cxA.setAnalyticsCollectionEnabled(z);
        }
    }

    public boolean abD() {
        MFUser currentUser = cnq.acd().ace().getCurrentUser();
        return currentUser != null && currentUser.isDiagnosticEnabled();
    }

    public void m7086l(String str, String str2, String str3) {
        MFLogger.m12670d(TAG, "Inside .analyticLogEvent event=" + str + ", name=" + str2 + ", value=" + str3);
        Bundle bundle = new Bundle();
        bundle.putString(str2, str3);
        cxA.logEvent(str, bundle);
    }

    public void m7085e(String str, Map<String, String> map) {
        MFLogger.m12670d(TAG, "Inside .analyticLogEvent event=" + str + ", value=" + map);
        if (map != null && !map.isEmpty()) {
            Bundle bundle = new Bundle();
            for (Entry entry : map.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            cxA.logEvent(str, bundle);
        }
    }

    public void logEvent(String str) {
        MFLogger.m12670d(TAG, "Inside .analyticLogEvent event=" + str);
        cxA.logEvent(str, null);
    }

    public void ap(String str, String str2) {
        cxA.setUserProperty(str, str2);
    }

    public void m7087w(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                cxA.setUserProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
