package com.fossil;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;

public final class ceg {
    private final String bPq;
    private final String bPr;
    private final String bPs;
    private final String bPt;
    private final String bPu;
    private final String bPv;
    private final String bPw;

    private ceg(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        awa.m4634a(!axw.dj(str), "ApplicationId must be set.");
        this.bPr = str;
        this.bPq = str2;
        this.bPs = str3;
        this.bPt = str4;
        this.bPu = str5;
        this.bPv = str6;
        this.bPw = str7;
    }

    public static ceg ba(Context context) {
        awk com_fossil_awk = new awk(context);
        Object string = com_fossil_awk.getString("google_app_id");
        return TextUtils.isEmpty(string) ? null : new ceg(string, com_fossil_awk.getString("google_api_key"), com_fossil_awk.getString("firebase_database_url"), com_fossil_awk.getString("ga_trackingId"), com_fossil_awk.getString("gcm_defaultSenderId"), com_fossil_awk.getString("google_storage_bucket"), com_fossil_awk.getString("project_id"));
    }

    public final String VV() {
        return this.bPu;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ceg)) {
            return false;
        }
        ceg com_fossil_ceg = (ceg) obj;
        return avx.equal(this.bPr, com_fossil_ceg.bPr) && avx.equal(this.bPq, com_fossil_ceg.bPq) && avx.equal(this.bPs, com_fossil_ceg.bPs) && avx.equal(this.bPt, com_fossil_ceg.bPt) && avx.equal(this.bPu, com_fossil_ceg.bPu) && avx.equal(this.bPv, com_fossil_ceg.bPv) && avx.equal(this.bPw, com_fossil_ceg.bPw);
    }

    public final String getApplicationId() {
        return this.bPr;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bPr, this.bPq, this.bPs, this.bPt, this.bPu, this.bPv, this.bPw});
    }

    public final String toString() {
        return avx.bN(this).m4608b("applicationId", this.bPr).m4608b("apiKey", this.bPq).m4608b("databaseUrl", this.bPs).m4608b("gcmSenderId", this.bPu).m4608b("storageBucket", this.bPv).m4608b("projectId", this.bPw).toString();
    }
}
