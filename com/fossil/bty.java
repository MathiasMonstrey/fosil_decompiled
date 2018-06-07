package com.fossil;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bty implements Creator<btx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int z = aur.m4535z(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    intent = (Intent) aur.m4505a(parcel, readInt, Intent.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new btx(i2, i, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new btx[i];
    }
}
