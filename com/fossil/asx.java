package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class asx extends buj implements asw {
    asx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void mo1173a(asu com_fossil_asu, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_asu);
        bul.m5687a(SH, (Parcelable) googleSignInOptions);
        m4421b(102, SH);
    }

    public final void mo1174b(asu com_fossil_asu, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel SH = SH();
        bul.m5686a(SH, (IInterface) com_fossil_asu);
        bul.m5687a(SH, (Parcelable) googleSignInOptions);
        m4421b(103, SH);
    }
}
