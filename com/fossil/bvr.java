package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class bvr implements Creator<bvq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        int z = aur.m4535z(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str4 = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    list = aur.m4500A(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bvq(str4, str3, str2, str, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bvq[i];
    }
}
