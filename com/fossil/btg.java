package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.btf.C1944a;
import com.fossil.btf.C1950b;
import com.fossil.btf.C1952c;
import com.fossil.btf.C1954d;
import com.fossil.btf.C1956e;
import com.fossil.btf.C1958f;
import com.fossil.btf.C1960g;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class btg implements Creator<btf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C1944a c1944a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C1950b c1950b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C1952c c1952c = null;
        boolean z2 = false;
        String str7 = null;
        C1954d c1954d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z3 = false;
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
                case 3:
                    C1944a c1944a2 = (C1944a) aur.m4505a(parcel, readInt, C1944a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1944a = c1944a2;
                    break;
                case 4:
                    str2 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    C1950b c1950b2 = (C1950b) aur.m4505a(parcel, readInt, C1950b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c1950b = c1950b2;
                    break;
                case 8:
                    str4 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    C1952c c1952c2 = (C1952c) aur.m4505a(parcel, readInt, C1952c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c1952c = c1952c2;
                    break;
                case 16:
                    z2 = aur.m4512c(parcel, readInt);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    C1954d c1954d2 = (C1954d) aur.m4505a(parcel, readInt, C1954d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c1954d = c1954d2;
                    break;
                case 20:
                    str8 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = aur.m4511c(parcel, readInt, C1956e.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = aur.m4511c(parcel, readInt, C1958f.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = aur.m4515f(parcel, readInt);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = aur.m4525p(parcel, readInt);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = aur.m4511c(parcel, readInt, C1960g.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z3 = aur.m4512c(parcel, readInt);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == z) {
            return new btf(hashSet, i, str, c1944a, str2, str3, i2, c1950b, str4, str5, i3, str6, c1952c, z2, str7, c1954d, str8, i4, list, list2, i5, i6, str9, str10, list3, z3);
        }
        throw new zzc("Overread allowed size end=" + z, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new btf[i];
    }
}
