package com.fossil;

import android.content.SharedPreferences.Editor;

public final class boz {
    private boolean bAr;
    private /* synthetic */ bow bAt;
    private final long bAu;
    private long bAv;
    private final String bvf;

    public boz(bow com_fossil_bow, String str, long j) {
        this.bAt = com_fossil_bow;
        awa.df(str);
        this.bvf = str;
        this.bAu = j;
    }

    public final long get() {
        if (!this.bAr) {
            this.bAr = true;
            this.bAv = this.bAt.bzV.getLong(this.bvf, this.bAu);
        }
        return this.bAv;
    }

    public final void set(long j) {
        Editor edit = this.bAt.bzV.edit();
        edit.putLong(this.bvf, j);
        edit.apply();
        this.bAv = j;
    }
}
