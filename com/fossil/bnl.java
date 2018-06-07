package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bnl implements Creator<bnk> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        bsh com_fossil_bsh = null;
        long j = 0;
        boolean z2 = false;
        String str3 = null;
        bnz com_fossil_bnz = null;
        long j2 = 0;
        bnz com_fossil_bnz2 = null;
        long j3 = 0;
        bnz com_fossil_bnz3 = null;
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
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    com_fossil_bsh = (bsh) aur.m4505a(parcel, readInt, bsh.CREATOR);
                    break;
                case 5:
                    j = aur.m4517h(parcel, readInt);
                    break;
                case 6:
                    z2 = aur.m4512c(parcel, readInt);
                    break;
                case 7:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 8:
                    com_fossil_bnz = (bnz) aur.m4505a(parcel, readInt, bnz.CREATOR);
                    break;
                case 9:
                    j2 = aur.m4517h(parcel, readInt);
                    break;
                case 10:
                    com_fossil_bnz2 = (bnz) aur.m4505a(parcel, readInt, bnz.CREATOR);
                    break;
                case 11:
                    j3 = aur.m4517h(parcel, readInt);
                    break;
                case 12:
                    com_fossil_bnz3 = (bnz) aur.m4505a(parcel, readInt, bnz.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bnk(i, str, str2, com_fossil_bsh, j, z2, str3, com_fossil_bnz, j2, com_fossil_bnz2, j3, com_fossil_bnz3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bnk[i];
    }
}
