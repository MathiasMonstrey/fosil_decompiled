package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbo implements Creator<cbn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int z = aur.m4535z(parcel);
        String str2 = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    bArr = aur.m4528s(parcel, readInt);
                    break;
                case 5:
                    str = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new cbn(i, str2, bArr, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cbn[i];
    }
}
