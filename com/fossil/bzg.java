package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class bzg implements Creator<byu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int z = aur.m4535z(parcel);
        float f2 = 0.0f;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    f2 = aur.m4520k(parcel, readInt);
                    break;
                case 3:
                    f = aur.m4520k(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new byu(f2, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new byu[i];
    }
}
