package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbe implements Creator<cbd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int z = aur.m4535z(parcel);
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new cbd(str3, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cbd[i];
    }
}
