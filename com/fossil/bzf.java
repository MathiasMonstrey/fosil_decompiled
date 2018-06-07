package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class bzf implements Creator<StreetViewPanoramaCamera> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int z = aur.m4535z(parcel);
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    f3 = aur.m4520k(parcel, readInt);
                    break;
                case 3:
                    f2 = aur.m4520k(parcel, readInt);
                    break;
                case 4:
                    f = aur.m4520k(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new StreetViewPanoramaCamera(f3, f2, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}
