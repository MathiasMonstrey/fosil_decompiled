package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bar implements Creator<bab> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int z = aur.m4535z(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str4 = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 6:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 1000:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bab(i3, str4, str3, str2, str, i2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bab[i];
    }
}
