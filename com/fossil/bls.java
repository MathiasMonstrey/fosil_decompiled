package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public class bls extends axg<bmh> {
    private final String bwf;
    protected final bmu<bmh> bwg = new blt(this);

    public bls(Context context, Looper looper, C1898b c1898b, C1899c c1899c, String str, awy com_fossil_awy) {
        super(context, looper, 23, com_fossil_awy, c1898b, c1899c);
        this.bwf = str;
    }

    protected final Bundle JJ() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.bwf);
        return bundle;
    }

    protected final String Kh() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected final String Ki() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof bmh ? (bmh) queryLocalInterface : new bmi(iBinder);
    }
}
