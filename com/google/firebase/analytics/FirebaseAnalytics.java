package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.fossil.awa;
import com.fossil.bpk;
import com.fossil.cag;
import com.j256.ormlite.field.FieldType;

@Keep
public final class FirebaseAnalytics {
    private final bpk zzboe;

    public static class C4260a {
    }

    public static class C4261b {
    }

    public static class C4262c {
    }

    public FirebaseAnalytics(bpk com_fossil_bpk) {
        awa.bO(com_fossil_bpk);
        this.zzboe = com_fossil_bpk;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        return bpk.aR(context).RF();
    }

    public final cag<String> getAppInstanceId() {
        return this.zzboe.OS().getAppInstanceId();
    }

    public final void logEvent(String str, Bundle bundle) {
        this.zzboe.RE().logEvent(str, bundle);
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        this.zzboe.RE().setMeasurementEnabled(z);
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzboe.OW().setCurrentScreen(activity, str, str2);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zzboe.RE().setMinimumSessionDuration(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zzboe.RE().setSessionTimeoutDuration(j);
    }

    public final void setUserId(String str) {
        this.zzboe.RE().setUserPropertyInternal("app", FieldType.FOREIGN_ID_FIELD_SUFFIX, str);
    }

    public final void setUserProperty(String str, String str2) {
        this.zzboe.RE().setUserProperty(str, str2);
    }
}
