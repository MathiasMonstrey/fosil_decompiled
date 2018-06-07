package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.ats.C1893g;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bjz extends bjm<bkp> {
    public static final ats<Object> bfF = new ats("Fitness.INTERNAL_API", new bka(), bvi);
    private static C1893g<bjz> bvi = new C1893g();

    public bjz(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 61, c1898b, c1899c, com_fossil_awy);
    }

    public final String Kh() {
        return "com.google.android.gms.fitness.InternalApi";
    }

    public final String Ki() {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }

    public final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
        return queryLocalInterface instanceof bkp ? (bkp) queryLocalInterface : new bkq(iBinder);
    }
}
