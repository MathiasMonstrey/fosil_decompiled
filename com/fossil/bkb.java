package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.ats.C1893g;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bkb extends bjm<bkr> {
    public static final ats<Object> bfF = new ats("Fitness.RECORDING_API", new bkc(), bvi);
    private static C1893g<bkb> bvi = new C1893g();

    public bkb(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 56, c1898b, c1899c, com_fossil_awy);
    }

    public final String Kh() {
        return "com.google.android.gms.fitness.RecordingApi";
    }

    public final String Ki() {
        return "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi";
    }

    public final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
        return queryLocalInterface instanceof bkr ? (bkr) queryLocalInterface : new bks(iBinder);
    }
}
