package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.arz.C1883a;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bdb extends axg<bdc> {
    private final C1883a brd;

    public bdb(Context context, Looper looper, awy com_fossil_awy, C1883a c1883a, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 68, com_fossil_awy, c1898b, c1899c);
        this.brd = c1883a;
    }

    protected final Bundle JJ() {
        return this.brd == null ? new Bundle() : this.brd.JJ();
    }

    protected final String Kh() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    protected final String Ki() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return queryLocalInterface instanceof bdc ? (bdc) queryLocalInterface : new bdd(iBinder);
    }
}
