package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bih implements Creator<big> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        bii com_fossil_bii = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    com_fossil_bii = (bii) aur.m4505a(parcel, readInt, bii.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new big(i, com_fossil_bii);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new big[i];
    }
}
