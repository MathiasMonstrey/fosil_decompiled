package com.fossil;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

class ada {
    private final epr aJz;
    private final Context context;

    public ada(Context context, epr com_fossil_epr) {
        this.context = context;
        this.aJz = com_fossil_epr;
    }

    public String getTitle() {
        return m3020o("com.crashlytics.CrashSubmissionPromptTitle", this.aJz.title);
    }

    public String getMessage() {
        return m3020o("com.crashlytics.CrashSubmissionPromptMessage", this.aJz.message);
    }

    public String yp() {
        return m3020o("com.crashlytics.CrashSubmissionSendTitle", this.aJz.dQo);
    }

    public String yq() {
        return m3020o("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.aJz.dQs);
    }

    public String yr() {
        return m3020o("com.crashlytics.CrashSubmissionCancelTitle", this.aJz.dQq);
    }

    private String m3020o(String str, String str2) {
        return m3021p(CommonUtils.aa(this.context, str), str2);
    }

    private String m3021p(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
