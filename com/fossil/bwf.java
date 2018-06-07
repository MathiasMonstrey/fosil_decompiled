package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class bwf implements Creator<bvu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int z = aur.m4535z(parcel);
        List list = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i6 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i5 = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    i4 = aur.m4515f(parcel, readInt);
                    break;
                case 4:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                case 5:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 6:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 7:
                    list = aur.m4511c(parcel, readInt, bvt.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bvu(i6, i5, i4, i3, i2, i, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bvu[i];
    }
}
