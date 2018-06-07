package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;

public final class bzd implements Creator<LatLng> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int z = aur.m4535z(parcel);
        double d2 = 0.0d;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    d2 = aur.m4522m(parcel, readInt);
                    break;
                case 3:
                    d = aur.m4522m(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new LatLng(d2, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LatLng[i];
    }
}
