package com.fossil;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bmt implements Creator<bms> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int z = aur.m4535z(parcel);
        int i = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        bmq com_fossil_bmq = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    com_fossil_bmq = (bmq) aur.m4505a(parcel, readInt, bmq.CREATOR);
                    break;
                case 3:
                    iBinder3 = aur.m4526q(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) aur.m4505a(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = aur.m4526q(parcel, readInt);
                    break;
                case 6:
                    iBinder = aur.m4526q(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bms(i, com_fossil_bmq, iBinder3, pendingIntent, iBinder2, iBinder);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bms[i];
    }
}
