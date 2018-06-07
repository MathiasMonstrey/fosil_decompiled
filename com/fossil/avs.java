package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public abstract class avs extends buk implements avr {
    public static avr m4602h(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof avr ? (avr) queryLocalInterface : new avt(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        IInterface La;
        boolean a;
        switch (i) {
            case 1:
                La = La();
                parcel2.writeNoException();
                bul.m5686a(parcel2, La);
                break;
            case 2:
                La = Lb();
                parcel2.writeNoException();
                bul.m5686a(parcel2, La);
                break;
            case 3:
                a = mo1203a(parcel.readString(), C1901a.m4703k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                bul.m5688a(parcel2, a);
                break;
            case 4:
                a = mo1204b(parcel.readString(), C1901a.m4703k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                bul.m5688a(parcel2, a);
                break;
            case 5:
                a = mo1202a((aym) bul.m5685a(parcel, aym.CREATOR), C1901a.m4703k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                bul.m5688a(parcel2, a);
                break;
            default:
                return false;
        }
        return true;
    }
}
