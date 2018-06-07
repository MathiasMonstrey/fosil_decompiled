package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bia extends axg<bid> {
    public bia(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 39, com_fossil_awy, c1898b, c1899c);
    }

    public final String Kh() {
        return "com.google.android.gms.common.service.START";
    }

    protected final String Ki() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        return queryLocalInterface instanceof bid ? (bid) queryLocalInterface : new bie(iBinder);
    }
}
