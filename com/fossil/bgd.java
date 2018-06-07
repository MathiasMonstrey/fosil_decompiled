package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.fossil.arv.C1875c;
import com.google.android.gms.common.api.Status;

@Deprecated
public final class bgd {
    private static final Object bhH = new Object();
    private static bgd bul;
    private final Status bum;
    private final boolean bun;
    private final boolean buo;
    private final String mAppId;

    private bgd(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C1875c.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.buo = z;
            z = z2;
        } else {
            this.buo = false;
        }
        this.bun = z;
        Object ao = avw.ao(context);
        if (ao == null) {
            ao = new awk(context).getString("google_app_id");
        }
        if (TextUtils.isEmpty(ao)) {
            this.bum = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.mAppId = null;
            return;
        }
        this.mAppId = ao;
        this.bum = Status.bgw;
    }

    public static String Oh() {
        return dH("getGoogleAppId").mAppId;
    }

    public static boolean Oi() {
        return dH("isMeasurementExplicitlyDisabled").buo;
    }

    public static Status aN(Context context) {
        Status status;
        awa.m4640p(context, "Context must not be null.");
        synchronized (bhH) {
            if (bul == null) {
                bul = new bgd(context);
            }
            status = bul.bum;
        }
        return status;
    }

    private static bgd dH(String str) {
        bgd com_fossil_bgd;
        synchronized (bhH) {
            if (bul == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            com_fossil_bgd = bul;
        }
        return com_fossil_bgd;
    }
}
