package com.fossil;

import android.content.SharedPreferences.Editor;

public final class bpb {
    private final String bAA = null;
    private boolean bAr;
    private /* synthetic */ bow bAt;
    private final String bvf;
    private String mValue;

    public bpb(bow com_fossil_bow, String str, String str2) {
        this.bAt = com_fossil_bow;
        awa.df(str);
        this.bvf = str;
    }

    public final String Rv() {
        if (!this.bAr) {
            this.bAr = true;
            this.mValue = this.bAt.bzV.getString(this.bvf, null);
        }
        return this.mValue;
    }

    public final void eo(String str) {
        if (!bsk.ae(str, this.mValue)) {
            Editor edit = this.bAt.bzV.edit();
            edit.putString(this.bvf, str);
            edit.apply();
            this.mValue = str;
        }
    }
}
