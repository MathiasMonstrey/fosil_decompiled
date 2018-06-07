package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bir implements Creator<biu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        bin com_fossil_bin = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    com_fossil_bin = (bin) aur.m4505a(parcel, readInt, bin.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new biu(i, str, com_fossil_bin);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new biu[i];
    }
}
