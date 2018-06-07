package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class bwc implements Creator<bvg> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = null;
        List list2 = null;
        String str2 = null;
        List list3 = null;
        String str3 = null;
        List list4 = null;
        String str4 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    str4 = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    list4 = aur.m4536z(parcel, readInt);
                    break;
                case 4:
                    list3 = aur.m4511c(parcel, readInt, bwb.CREATOR);
                    break;
                case 5:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 6:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 7:
                    list2 = aur.m4511c(parcel, readInt, bwb.CREATOR);
                    break;
                case 8:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 9:
                    list = aur.m4511c(parcel, readInt, bwb.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bvg(str4, list4, i, str3, list3, str2, list2, str, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bvg[i];
    }
}
