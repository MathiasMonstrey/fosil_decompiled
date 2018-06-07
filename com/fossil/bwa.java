package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bwa implements Creator<bwb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int z = aur.m4535z(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bwb(i2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bwb[i];
    }
}
