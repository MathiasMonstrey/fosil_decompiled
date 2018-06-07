package com.fossil;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class byw extends buk implements byv {
    public static byv m5824p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        return queryLocalInterface instanceof byv ? (byv) queryLocalInterface : new byx(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        IInterface ir;
        switch (i) {
            case 1:
                ir = ir(parcel.readInt());
                parcel2.writeNoException();
                bul.m5686a(parcel2, ir);
                break;
            case 2:
                ir = eU(parcel.readString());
                parcel2.writeNoException();
                bul.m5686a(parcel2, ir);
                break;
            case 3:
                ir = eV(parcel.readString());
                parcel2.writeNoException();
                bul.m5686a(parcel2, ir);
                break;
            case 4:
                ir = TF();
                parcel2.writeNoException();
                bul.m5686a(parcel2, ir);
                break;
            case 5:
                ir = ah(parcel.readFloat());
                parcel2.writeNoException();
                bul.m5686a(parcel2, ir);
                break;
            case 6:
                ir = mo1549r((Bitmap) bul.m5685a(parcel, Bitmap.CREATOR));
                parcel2.writeNoException();
                bul.m5686a(parcel2, ir);
                break;
            case 7:
                ir = eW(parcel.readString());
                parcel2.writeNoException();
                bul.m5686a(parcel2, ir);
                break;
            default:
                return false;
        }
        return true;
    }
}
