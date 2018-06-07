package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bui implements Creator<buh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        atn com_fossil_atn = null;
        int i = 0;
        awd com_fossil_awd = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    com_fossil_atn = (atn) aur.m4505a(parcel, readInt, atn.CREATOR);
                    break;
                case 3:
                    com_fossil_awd = (awd) aur.m4505a(parcel, readInt, awd.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new buh(i, com_fossil_atn, com_fossil_awd);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new buh[i];
    }
}
