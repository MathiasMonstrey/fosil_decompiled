package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bug implements Creator<buf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        awb com_fossil_awb = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    com_fossil_awb = (awb) aur.m4505a(parcel, readInt, awb.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new buf(i, com_fossil_awb);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new buf[i];
    }
}
