package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;

public final class awg implements Creator<awf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int z = aur.m4535z(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 3:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 4:
                    scopeArr = (Scope[]) aur.m4510b(parcel, readInt, Scope.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new awf(i3, i2, i, scopeArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new awf[i];
    }
}
