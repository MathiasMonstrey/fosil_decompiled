package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class asp implements Creator<asq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int z = aur.m4535z(parcel);
        Bundle bundle = null;
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
                    bundle = aur.m4527r(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new asq(i2, i, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new asq[i];
    }
}
