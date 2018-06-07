package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.ats.C1893g;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bjt extends bjm<bkl> {
    public static final ats<Object> bfF = new ats("Fitness.GOALS_API", new bju(), bvi);
    private static C1893g<bjt> bvi = new C1893g();

    public bjt(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 125, c1898b, c1899c, com_fossil_awy);
    }

    public final String Kh() {
        return "com.google.android.gms.fitness.GoalsApi";
    }

    public final String Ki() {
        return "com.google.android.gms.fitness.internal.IGoogleFitGoalsApi";
    }

    public final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitGoalsApi");
        return queryLocalInterface instanceof bkl ? (bkl) queryLocalInterface : new bkm(iBinder);
    }
}
