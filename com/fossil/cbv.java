package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cbv implements Creator<cbu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        String str7 = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    str3 = aur.m4525p(parcel, readInt);
                    break;
                case 6:
                    str4 = aur.m4525p(parcel, readInt);
                    break;
                case 7:
                    str5 = aur.m4525p(parcel, readInt);
                    break;
                case 8:
                    str6 = aur.m4525p(parcel, readInt);
                    break;
                case 9:
                    b = aur.m4514e(parcel, readInt);
                    break;
                case 10:
                    b2 = aur.m4514e(parcel, readInt);
                    break;
                case 11:
                    b3 = aur.m4514e(parcel, readInt);
                    break;
                case 12:
                    b4 = aur.m4514e(parcel, readInt);
                    break;
                case 13:
                    str7 = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new cbu(i, str, str2, str3, str4, str5, str6, b, b2, b3, b4, str7);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cbu[i];
    }
}
