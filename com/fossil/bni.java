package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bni implements Creator<bnh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z2 = true;
        boolean z3 = false;
        long j3 = -2147483648L;
        String str6 = null;
        long j4 = 0;
        long j5 = 0;
        int i = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 3:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    str4 = aur.m4525p(parcel, readInt);
                    break;
                case 6:
                    j = aur.m4517h(parcel, readInt);
                    break;
                case 7:
                    j2 = aur.m4517h(parcel, readInt);
                    break;
                case 8:
                    str5 = aur.m4525p(parcel, readInt);
                    break;
                case 9:
                    z2 = aur.m4512c(parcel, readInt);
                    break;
                case 10:
                    z3 = aur.m4512c(parcel, readInt);
                    break;
                case 11:
                    j3 = aur.m4517h(parcel, readInt);
                    break;
                case 12:
                    str6 = aur.m4525p(parcel, readInt);
                    break;
                case 13:
                    j4 = aur.m4517h(parcel, readInt);
                    break;
                case 14:
                    j5 = aur.m4517h(parcel, readInt);
                    break;
                case 15:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bnh(str, str2, str3, str4, j, j2, str5, z2, z3, j3, str6, j4, j5, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bnh[i];
    }
}
