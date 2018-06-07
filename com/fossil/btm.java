package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.btf.C1954d;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.HashSet;
import java.util.Set;

public final class btm implements Creator<C1954d> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int z = aur.m4535z(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == z) {
            return new C1954d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new zzc("Overread allowed size end=" + z, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C1954d[i];
    }
}
