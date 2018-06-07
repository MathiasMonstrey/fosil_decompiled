package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.ats.C1893g;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bjv extends bjm<bkn> {
    public static final ats<Object> bfF = new ats("Fitness.API", new bjx(), bvi);
    private static C1893g<bjv> bvi = new C1893g();

    public bjv(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 57, c1898b, c1899c, com_fossil_awy);
    }

    public final String Kh() {
        return "com.google.android.gms.fitness.HistoryApi";
    }

    public final String Ki() {
        return "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi";
    }

    public final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
        return queryLocalInterface instanceof bkn ? (bkn) queryLocalInterface : new bko(iBinder);
    }
}
