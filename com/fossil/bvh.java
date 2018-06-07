package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import java.util.Locale;

public final class bvh extends axg<bwm> {
    private final Locale bGW;
    private final bvx bHB;

    private bvh(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c, String str, bve com_fossil_bve) {
        super(context, looper, 67, com_fossil_awy, c1898b, c1899c);
        this.bGW = Locale.getDefault();
        this.bHB = new bvx(str, this.bGW, com_fossil_awy.KQ() != null ? com_fossil_awy.KQ().name : null, null, 0);
    }

    protected final String Kh() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    protected final String Ki() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
        return queryLocalInterface instanceof bwm ? (bwm) queryLocalInterface : new bwn(iBinder);
    }
}
