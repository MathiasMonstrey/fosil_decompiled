package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.PlusCommonExtras;

public final class bzw implements Creator<PlusCommonExtras> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 1000:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new PlusCommonExtras(i, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlusCommonExtras[i];
    }
}
