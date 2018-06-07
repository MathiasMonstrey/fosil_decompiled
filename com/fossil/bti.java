package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.btf.C1950b;
import com.fossil.btf.C1950b.C1946a;
import com.fossil.btf.C1950b.C1948b;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.HashSet;
import java.util.Set;

public final class bti implements Creator<C1950b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        C1948b c1948b = null;
        int i = 0;
        int z = aur.m4535z(parcel);
        Set hashSet = new HashSet();
        C1946a c1946a = null;
        int i2 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    C1946a c1946a2 = (C1946a) aur.m4505a(parcel, readInt, C1946a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c1946a = c1946a2;
                    break;
                case 3:
                    C1948b c1948b2 = (C1948b) aur.m4505a(parcel, readInt, C1948b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1948b = c1948b2;
                    break;
                case 4:
                    i = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == z) {
            return new C1950b(hashSet, i2, c1946a, c1948b, i);
        }
        throw new zzc("Overread allowed size end=" + z, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C1950b[i];
    }
}
