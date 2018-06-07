package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class biv implements Creator<bis> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    arrayList = aur.m4511c(parcel, readInt, bit.CREATOR);
                    break;
                case 3:
                    str = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bis(i, arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bis[i];
    }
}
