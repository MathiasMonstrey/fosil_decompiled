package com.fossil;

import android.content.Context;
import android.os.Bundle;

public class dsn {
    private String bhE = "";
    private String dqh = "";
    private String dqi = "";
    private String dqj = "";
    private String dqk = "";

    public dsn(Context context, String str, String str2, String str3) {
        this.dqh = str;
        this.dqi = str2;
        this.dqj = str3;
        this.bhE = context.getPackageName();
        this.dqk = duq.m9791T(context, this.bhE);
    }

    public String awy() {
        return this.dqh;
    }

    public String getRedirectUrl() {
        return this.dqi;
    }

    public String awz() {
        return this.dqj;
    }

    public String getPackageName() {
        return this.bhE;
    }

    public String awA() {
        return this.dqk;
    }

    public Bundle awB() {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", this.dqh);
        bundle.putString("redirectUri", this.dqi);
        bundle.putString("scope", this.dqj);
        bundle.putString("packagename", this.bhE);
        bundle.putString("key_hash", this.dqk);
        return bundle;
    }

    public static dsn m9624e(Context context, Bundle bundle) {
        return new dsn(context, bundle.getString("appKey"), bundle.getString("redirectUri"), bundle.getString("scope"));
    }
}
