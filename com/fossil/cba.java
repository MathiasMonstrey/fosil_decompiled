package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class cba implements Creator<caz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        int z = aur.m4535z(parcel);
        String str = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    list = aur.m4511c(parcel, readInt, cbp.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new caz(str, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new caz[i];
    }
}
