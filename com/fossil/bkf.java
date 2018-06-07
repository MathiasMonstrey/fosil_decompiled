package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.ats.C1893g;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bkf extends bjm<bkv> {
    public static final ats<Object> bfF = new ats("Fitness.SESSIONS_API", new bkg(), bvi);
    private static C1893g<bkf> bvi = new C1893g();

    public bkf(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 58, c1898b, c1899c, com_fossil_awy);
    }

    public final String Kh() {
        return "com.google.android.gms.fitness.SessionsApi";
    }

    public final String Ki() {
        return "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi";
    }

    public final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
        return queryLocalInterface instanceof bkv ? (bkv) queryLocalInterface : new bkw(iBinder);
    }
}
