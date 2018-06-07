package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataType;

public final class bao implements Creator<baa> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int[] iArr = null;
        int z = aur.m4535z(parcel);
        String str = null;
        bah com_fossil_bah = null;
        bab com_fossil_bab = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    dataType = (DataType) aur.m4505a(parcel, readInt, DataType.CREATOR);
                    break;
                case 2:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 4:
                    com_fossil_bab = (bab) aur.m4505a(parcel, readInt, bab.CREATOR);
                    break;
                case 5:
                    com_fossil_bah = (bah) aur.m4505a(parcel, readInt, bah.CREATOR);
                    break;
                case 6:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 8:
                    iArr = aur.m4530u(parcel, readInt);
                    break;
                case 1000:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new baa(i2, dataType, str2, i, com_fossil_bab, com_fossil_bah, str, iArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new baa[i];
    }
}
