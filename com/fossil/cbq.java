package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbq implements Creator<cbp> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int z2 = aur.m4535z(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < z2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 5:
                    z = aur.m4512c(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z2);
        return new cbp(str2, str, i, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cbp[i];
    }
}
