package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.btf.C1958f;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.HashSet;
import java.util.Set;

public final class bto implements Creator<C1958f> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int z2 = aur.m4535z(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < z2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = aur.m4512c(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == z2) {
            return new C1958f(hashSet, i, z, str);
        }
        throw new zzc("Overread allowed size end=" + z2, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C1958f[i];
    }
}
