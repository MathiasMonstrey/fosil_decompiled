package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class biy implements Creator<bix> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        bis com_fossil_bis = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    parcel2 = aur.m4501B(parcel, readInt);
                    break;
                case 3:
                    com_fossil_bis = (bis) aur.m4505a(parcel, readInt, bis.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bix(i, parcel2, com_fossil_bis);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bix[i];
    }
}
