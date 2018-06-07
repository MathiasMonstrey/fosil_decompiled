package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bas implements Creator<bac> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Boolean bool = null;
        int i = 0;
        int z = aur.m4535z(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    bool = aur.m4513d(parcel, readInt);
                    break;
                case 1000:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bac(i2, str, i, bool);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bac[i];
    }
}
