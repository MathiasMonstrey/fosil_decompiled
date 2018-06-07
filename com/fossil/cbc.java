package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbc implements Creator<cbb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        int i2 = 0;
        cbd com_fossil_cbd = null;
        int i3 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    com_fossil_cbd = (cbd) aur.m4505a(parcel, readInt, cbd.CREATOR);
                    break;
                case 3:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 4:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 5:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new cbb(com_fossil_cbd, i2, i, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cbb[i];
    }
}
