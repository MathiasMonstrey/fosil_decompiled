package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class boa implements Creator<bnz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int z = aur.m4535z(parcel);
        long j = 0;
        bnw com_fossil_bnw = null;
        String str2 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    com_fossil_bnw = (bnw) aur.m4505a(parcel, readInt, bnw.CREATOR);
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    j = aur.m4517h(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bnz(str2, com_fossil_bnw, str, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bnz[i];
    }
}
