package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bde extends axg<bdf> {
    private final Bundle bfG;

    public bde(Context context, Looper looper, awy com_fossil_awy, atm com_fossil_atm, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 16, com_fossil_awy, c1898b, c1899c);
        this.bfG = com_fossil_atm == null ? new Bundle() : com_fossil_atm.Kr();
    }

    protected final Bundle JJ() {
        return this.bfG;
    }

    protected final String Kh() {
        return "com.google.android.gms.auth.service.START";
    }

    protected final String Ki() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    public final boolean Ky() {
        awy LC = LC();
        return (TextUtils.isEmpty(LC.Ls()) || LC.m4659d(atk.bfF).isEmpty()) ? false : true;
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return queryLocalInterface instanceof bdf ? (bdf) queryLocalInterface : new bdg(iBinder);
    }
}
