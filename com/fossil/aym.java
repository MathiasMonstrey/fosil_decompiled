package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;

public final class aym extends auq {
    public static final Creator<aym> CREATOR = new ayn();
    private final String bjt;
    private final ayg bju;
    private final boolean bjv;

    aym(String str, IBinder iBinder, boolean z) {
        this.bjt = str;
        this.bju = m4697j(iBinder);
        this.bjv = z;
    }

    aym(String str, ayg com_fossil_ayg, boolean z) {
        this.bjt = str;
        this.bju = com_fossil_ayg;
        this.bjv = z;
    }

    private static ayg m4697j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            ayg com_fossil_ayh;
            ayq KY = avl.m4594g(iBinder).KY();
            byte[] bArr = KY == null ? null : (byte[]) azc.m4739a(KY);
            if (bArr != null) {
                com_fossil_ayh = new ayh(bArr);
            } else {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                com_fossil_ayh = null;
            }
            return com_fossil_ayh;
        } catch (Throwable e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.bjt, false);
        if (this.bju == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = this.bju.asBinder();
        }
        aus.m4546a(parcel, 2, iBinder, false);
        aus.m4556a(parcel, 3, this.bjv);
        aus.m4540G(parcel, A);
    }
}
