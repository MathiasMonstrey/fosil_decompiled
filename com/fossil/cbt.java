package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbt implements Creator<cbs> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int z = aur.m4535z(parcel);
        String str = null;
        byte b2 = (byte) 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    b2 = aur.m4514e(parcel, readInt);
                    break;
                case 3:
                    b = aur.m4514e(parcel, readInt);
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
        return new cbs(b2, b, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cbs[i];
    }
}
