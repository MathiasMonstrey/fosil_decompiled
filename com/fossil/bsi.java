package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bsi implements Creator<bsh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Double d = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    j = aur.m4517h(parcel, readInt);
                    break;
                case 4:
                    l = aur.m4518i(parcel, readInt);
                    break;
                case 5:
                    f = aur.m4521l(parcel, readInt);
                    break;
                case 6:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 7:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 8:
                    d = aur.m4523n(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bsh(i, str3, j, l, f, str2, str, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bsh[i];
    }
}
