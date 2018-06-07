package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class biw implements Creator<bit> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
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
                    arrayList = aur.m4511c(parcel, readInt, biu.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bit(i, str, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bit[i];
    }
}
