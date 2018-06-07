package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class biq implements Creator<bin> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        big com_fossil_big = null;
        int i = 0;
        int z = aur.m4535z(parcel);
        String str = null;
        String str2 = null;
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i4 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    z3 = aur.m4512c(parcel, readInt);
                    break;
                case 4:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 5:
                    z2 = aur.m4512c(parcel, readInt);
                    break;
                case 6:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 7:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 8:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 9:
                    com_fossil_big = (big) aur.m4505a(parcel, readInt, big.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bin(i4, i3, z3, i2, z2, str2, i, str, com_fossil_big);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bin[i];
    }
}
