package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public final class bzb implements Creator<CameraPosition> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        float f = 0.0f;
        float f2 = 0.0f;
        LatLng latLng = null;
        float f3 = 0.0f;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    latLng = (LatLng) aur.m4505a(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = aur.m4520k(parcel, readInt);
                    break;
                case 4:
                    f = aur.m4520k(parcel, readInt);
                    break;
                case 5:
                    f3 = aur.m4520k(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new CameraPosition(latLng, f2, f, f3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CameraPosition[i];
    }
}
