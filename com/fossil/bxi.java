package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bxi implements Creator<bxh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = -1;
        int i = 1;
        int z = aur.m4535z(parcel);
        long j2 = -1;
        int i2 = 1;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    j2 = aur.m4517h(parcel, readInt);
                    break;
                case 4:
                    j = aur.m4517h(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bxh(i2, i, j2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bxh[i];
    }
}
