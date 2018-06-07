package com.fossil;

import android.app.PendingIntent;
import android.os.Bundle;

abstract class awn extends awr<Boolean> {
    private Bundle biw;
    private /* synthetic */ awm bix;
    private int statusCode;

    protected awn(awm com_fossil_awm, int i, Bundle bundle) {
        this.bix = com_fossil_awm;
        super(com_fossil_awm, Boolean.valueOf(true));
        this.statusCode = i;
        this.biw = bundle;
    }

    protected abstract boolean Lq();

    protected final /* synthetic */ void bP(Object obj) {
        PendingIntent pendingIntent = null;
        if (((Boolean) obj) == null) {
            this.bix.m4368a(1, null);
            return;
        }
        switch (this.statusCode) {
            case 0:
                if (!Lq()) {
                    this.bix.m4368a(1, null);
                    mo1212c(new atn(8, null));
                    return;
                }
                return;
            case 10:
                this.bix.m4368a(1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.bix.m4368a(1, null);
                if (this.biw != null) {
                    pendingIntent = (PendingIntent) this.biw.getParcelable("pendingIntent");
                }
                mo1212c(new atn(this.statusCode, pendingIntent));
                return;
        }
    }

    protected abstract void mo1212c(atn com_fossil_atn);
}
