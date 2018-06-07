package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bmx implements Creator<bmw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        String str = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bmw(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bmw[i];
    }
}
