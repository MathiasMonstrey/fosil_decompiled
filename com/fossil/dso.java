package com.fossil;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsConstants;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.misfit.frameworks.common.constants.Constants;

public class dso {
    private String dql = "";
    private String dqm = "";
    private String dqn = "";
    private long dqo = 0;
    private String dqp = "";

    public static dso m9625K(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        dso com_fossil_dso = new dso();
        com_fossil_dso.setUid(m9626a(bundle, Constants.PROFILE_KEY_UID, ""));
        com_fossil_dso.setToken(m9626a(bundle, "access_token", ""));
        com_fossil_dso.jA(m9626a(bundle, AccessToken.EXPIRES_IN_KEY, ""));
        com_fossil_dso.setRefreshToken(m9626a(bundle, UpPlatformSdkConstants.UP_PLATFORM_REFRESH_TOKEN, ""));
        com_fossil_dso.jB(m9626a(bundle, "phone_num", ""));
        return com_fossil_dso;
    }

    public boolean awC() {
        return !TextUtils.isEmpty(this.dqm);
    }

    public String toString() {
        return "uid: " + this.dql + ", " + "access_token" + ": " + this.dqm + ", " + UpPlatformSdkConstants.UP_PLATFORM_REFRESH_TOKEN + ": " + this.dqn + ", " + "phone_num" + ": " + this.dqp + ", " + AccessToken.EXPIRES_IN_KEY + ": " + Long.toString(this.dqo);
    }

    public void setUid(String str) {
        this.dql = str;
    }

    public String getToken() {
        return this.dqm;
    }

    public void setToken(String str) {
        this.dqm = str;
    }

    public void setRefreshToken(String str) {
        this.dqn = str;
    }

    public void aL(long j) {
        this.dqo = j;
    }

    public void jA(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            aL(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
        }
    }

    private static String m9626a(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return str2;
        }
        String string = bundle.getString(str);
        if (string != null) {
            return string;
        }
        return str2;
    }

    private void jB(String str) {
        this.dqp = str;
    }
}
