package com.fossil;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.fossil.ayq.C1901a;

public abstract class blp extends buk implements blo {
    public blp() {
        attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
    }

    public static blo asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return queryLocalInterface instanceof blo ? (blo) queryLocalInterface : new blq(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m4353a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                init(C1901a.m4703k(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), bul.m5684B(parcel), parcel.readInt());
                parcel2.writeNoException();
                bul.m5688a(parcel2, booleanFlagValue);
                return true;
            case 3:
                int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(intFlagValue);
                return true;
            case 4:
                long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(longFlagValue);
                return true;
            case 5:
                String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(stringFlagValue);
                return true;
            default:
                return false;
        }
    }
}
