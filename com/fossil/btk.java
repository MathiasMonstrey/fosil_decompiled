package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.btf.C1950b.C1948b;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.HashSet;
import java.util.Set;

public final class btk implements Creator<C1948b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int z = aur.m4535z(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
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
            return new C1948b(hashSet, i3, i2, str, i);
        }
        throw new zzc("Overread allowed size end=" + z, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C1948b[i];
    }
}
