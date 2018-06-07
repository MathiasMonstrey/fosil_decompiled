package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.PlusCommonExtras;

public final class bzz implements Creator<bzy> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str5 = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    strArr3 = aur.m4534y(parcel, readInt);
                    break;
                case 3:
                    strArr2 = aur.m4534y(parcel, readInt);
                    break;
                case 4:
                    strArr = aur.m4534y(parcel, readInt);
                    break;
                case 5:
                    str4 = aur.m4525p(parcel, readInt);
                    break;
                case 6:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 7:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 8:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) aur.m4505a(parcel, readInt, PlusCommonExtras.CREATOR);
                    break;
                case 1000:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bzy(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bzy[i];
    }
}
