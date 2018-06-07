package com.fossil;

import android.content.SharedPreferences.Editor;

public final class boy {
    private final boolean bAq = true;
    private boolean bAr;
    private boolean bAs;
    private /* synthetic */ bow bAt;
    private final String bvf;

    public boy(bow com_fossil_bow, String str, boolean z) {
        this.bAt = com_fossil_bow;
        awa.df(str);
        this.bvf = str;
    }

    public final boolean get() {
        if (!this.bAr) {
            this.bAr = true;
            this.bAs = this.bAt.bzV.getBoolean(this.bvf, this.bAq);
        }
        return this.bAs;
    }

    public final void set(boolean z) {
        Editor edit = this.bAt.bzV.edit();
        edit.putBoolean(this.bvf, z);
        edit.apply();
        this.bAs = z;
    }
}
