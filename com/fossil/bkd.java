package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.ats.C1893g;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;

public final class bkd extends bjm<bkt> {
    public static final ats<Object> bfF = new ats("Fitness.SENSORS_API", new bke(), bvi);
    private static C1893g<bkd> bvi = new C1893g();

    public bkd(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 55, c1898b, c1899c, com_fossil_awy);
    }

    public final String Kh() {
        return "com.google.android.gms.fitness.SensorsApi";
    }

    public final String Ki() {
        return "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi";
    }

    public final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
        return queryLocalInterface instanceof bkt ? (bkt) queryLocalInterface : new bku(iBinder);
    }
}
