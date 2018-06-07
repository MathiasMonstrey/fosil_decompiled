package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ayn implements Creator<aym> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int z = aur.m4535z(parcel);
        boolean z2 = false;
        String str = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    iBinder = aur.m4526q(parcel, readInt);
                    break;
                case 3:
                    z2 = aur.m4512c(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new aym(str, iBinder, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new aym[i];
    }
}
