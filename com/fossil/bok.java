package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public final class bok extends awm<bod> {
    public bok(Context context, Looper looper, awo com_fossil_awo, awp com_fossil_awp) {
        super(context, looper, 93, com_fossil_awo, com_fossil_awp, null);
    }

    protected final String Kh() {
        return "com.google.android.gms.measurement.START";
    }

    protected final String Ki() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    public final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof bod ? (bod) queryLocalInterface : new bof(iBinder);
    }
}
