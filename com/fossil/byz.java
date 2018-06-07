package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;
import com.google.android.gms.maps.model.LatLng;

public abstract class byz extends buk implements byy {
    public static byy m5832q(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        return queryLocalInterface instanceof byy ? (byy) queryLocalInterface : new bza(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        String id;
        boolean Tz;
        IInterface queryLocalInterface;
        float rotation;
        switch (i) {
            case 1:
                remove();
                parcel2.writeNoException();
                break;
            case 2:
                id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                break;
            case 3:
                mo1564d((LatLng) bul.m5685a(parcel, LatLng.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                Parcelable Tl = Tl();
                parcel2.writeNoException();
                bul.m5689b(parcel2, Tl);
                break;
            case 5:
                setTitle(parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                id = getTitle();
                parcel2.writeNoException();
                parcel2.writeString(id);
                break;
            case 7:
                eX(parcel.readString());
                parcel2.writeNoException();
                break;
            case 8:
                id = Tw();
                parcel2.writeNoException();
                parcel2.writeString(id);
                break;
            case 9:
                bx(bul.m5684B(parcel));
                parcel2.writeNoException();
                break;
            case 10:
                Tz = Tz();
                parcel2.writeNoException();
                bul.m5688a(parcel2, Tz);
                break;
            case 11:
                TG();
                parcel2.writeNoException();
                break;
            case 12:
                TH();
                parcel2.writeNoException();
                break;
            case 13:
                Tz = TI();
                parcel2.writeNoException();
                bul.m5688a(parcel2, Tz);
                break;
            case 14:
                setVisible(bul.m5684B(parcel));
                parcel2.writeNoException();
                break;
            case 15:
                Tz = isVisible();
                parcel2.writeNoException();
                bul.m5688a(parcel2, Tz);
                break;
            case 16:
                byy com_fossil_byy;
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    com_fossil_byy = null;
                } else {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    com_fossil_byy = queryLocalInterface instanceof byy ? (byy) queryLocalInterface : new bza(readStrongBinder);
                }
                Tz = mo1560a(com_fossil_byy);
                parcel2.writeNoException();
                bul.m5688a(parcel2, Tz);
                break;
            case 17:
                int TJ = TJ();
                parcel2.writeNoException();
                parcel2.writeInt(TJ);
                break;
            case 18:
                mo1565e(C1901a.m4703k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 19:
                mo1578u(parcel.readFloat(), parcel.readFloat());
                parcel2.writeNoException();
                break;
            case 20:
                by(bul.m5684B(parcel));
                parcel2.writeNoException();
                break;
            case 21:
                Tz = TA();
                parcel2.writeNoException();
                bul.m5688a(parcel2, Tz);
                break;
            case 22:
                setRotation(parcel.readFloat());
                parcel2.writeNoException();
                break;
            case 23:
                rotation = getRotation();
                parcel2.writeNoException();
                parcel2.writeFloat(rotation);
                break;
            case 24:
                mo1579v(parcel.readFloat(), parcel.readFloat());
                parcel2.writeNoException();
                break;
            case 25:
                setAlpha(parcel.readFloat());
                parcel2.writeNoException();
                break;
            case 26:
                rotation = getAlpha();
                parcel2.writeNoException();
                parcel2.writeFloat(rotation);
                break;
            case 27:
                ai(parcel.readFloat());
                parcel2.writeNoException();
                break;
            case 28:
                rotation = TD();
                parcel2.writeNoException();
                parcel2.writeFloat(rotation);
                break;
            case 29:
                mo1567f(C1901a.m4703k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 30:
                queryLocalInterface = TK();
                parcel2.writeNoException();
                bul.m5686a(parcel2, queryLocalInterface);
                break;
            default:
                return false;
        }
        return true;
    }
}
