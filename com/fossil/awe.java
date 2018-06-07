package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class awe implements Creator<awd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        atn com_fossil_atn = null;
        boolean z = false;
        int z2 = aur.m4535z(parcel);
        boolean z3 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < z2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    iBinder = aur.m4526q(parcel, readInt);
                    break;
                case 3:
                    com_fossil_atn = (atn) aur.m4505a(parcel, readInt, atn.CREATOR);
                    break;
                case 4:
                    z3 = aur.m4512c(parcel, readInt);
                    break;
                case 5:
                    z = aur.m4512c(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z2);
        return new awd(i, iBinder, com_fossil_atn, z3, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new awd[i];
    }
}
