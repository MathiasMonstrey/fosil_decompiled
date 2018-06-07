package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.btf.C1960g;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.HashSet;
import java.util.Set;

public final class btp implements Creator<C1960g> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int z = aur.m4535z(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == z) {
            return new C1960g(hashSet, i3, str2, i2, str, i);
        }
        throw new zzc("Overread allowed size end=" + z, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C1960g[i];
    }
}
