package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationAvailability;

public final class bxd implements Creator<LocationAvailability> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 1;
        int z = aur.m4535z(parcel);
        int i2 = 1000;
        long j = 0;
        bxh[] com_fossil_bxhArr = null;
        int i3 = 1;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    j = aur.m4517h(parcel, readInt);
                    break;
                case 4:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 5:
                    com_fossil_bxhArr = (bxh[]) aur.m4510b(parcel, readInt, bxh.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new LocationAvailability(i2, i3, i, j, com_fossil_bxhArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
