package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.btf.C1952c;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.HashSet;
import java.util.Set;

public final class btl implements Creator<C1952c> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == z) {
            return new C1952c(hashSet, i, str);
        }
        throw new zzc("Overread allowed size end=" + z, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new C1952c[i];
    }
}
