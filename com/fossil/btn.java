package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.btf.C1956e;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.HashSet;
import java.util.Set;

public final class btn implements Creator<C1956e> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int z = aur.m4535z(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z2 = aur.m4512c(parcel, readInt);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == z) {
            return new C1956e(hashSet, i2, str7, str6, str5, str4, str3, z2, str2, str, i);
        }
        throw new zzc("Overread allowed size end=" + z, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C1956e[i];
    }
}
