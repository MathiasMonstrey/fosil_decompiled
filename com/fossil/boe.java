package com.fossil;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class boe extends buk implements bod {
    public boe() {
        attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        List a;
        switch (i) {
            case 1:
                mo1435a((bnz) bul.m5685a(parcel, bnz.CREATOR), (bnh) bul.m5685a(parcel, bnh.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                mo1437a((bsh) bul.m5685a(parcel, bsh.CREATOR), (bnh) bul.m5685a(parcel, bnh.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                mo1433a((bnh) bul.m5685a(parcel, bnh.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                mo1436a((bnz) bul.m5685a(parcel, bnz.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                mo1439b((bnh) bul.m5685a(parcel, bnh.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                a = mo1428a((bnh) bul.m5685a(parcel, bnh.CREATOR), bul.m5684B(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a);
                break;
            case 9:
                byte[] a2 = mo1438a((bnz) bul.m5685a(parcel, bnz.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(a2);
                break;
            case 10:
                mo1432a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                String c = mo1441c((bnh) bul.m5685a(parcel, bnh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(c);
                break;
            case 12:
                mo1434a((bnk) bul.m5685a(parcel, bnk.CREATOR), (bnh) bul.m5685a(parcel, bnh.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                mo1440b((bnk) bul.m5685a(parcel, bnk.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                a = mo1431a(parcel.readString(), parcel.readString(), bul.m5684B(parcel), (bnh) bul.m5685a(parcel, bnh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a);
                break;
            case 15:
                a = mo1430a(parcel.readString(), parcel.readString(), parcel.readString(), bul.m5684B(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a);
                break;
            case 16:
                a = mo1429a(parcel.readString(), parcel.readString(), (bnh) bul.m5685a(parcel, bnh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a);
                break;
            case 17:
                a = mo1442g(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(a);
                break;
            default:
                return false;
        }
        return true;
    }
}
