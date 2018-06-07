package com.fossil;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class cfe implements Creator<cez> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    bundle = aur.m4527r(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new cez(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new cez[i];
    }
}
