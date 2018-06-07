package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bav implements Creator<bay> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = aur.m4526q(parcel, readInt);
                    break;
                case 1000:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bay(i, iBinder);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bay[i];
    }
}
