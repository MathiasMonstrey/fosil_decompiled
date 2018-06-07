package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class bvv implements Creator<bvs> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        int z = aur.m4535z(parcel);
        List list2 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    list2 = aur.m4511c(parcel, readInt, bvt.CREATOR);
                    break;
                case 2:
                    list = aur.m4511c(parcel, readInt, bvu.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bvs(list2, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bvs[i];
    }
}
