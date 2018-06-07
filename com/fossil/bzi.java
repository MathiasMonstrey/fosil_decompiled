package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class bzi implements Creator<StreetViewPanoramaOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int z = aur.m4535z(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) aur.m4505a(parcel, readInt, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    latLng = (LatLng) aur.m4505a(parcel, readInt, LatLng.CREATOR);
                    break;
                case 5:
                    num = aur.m4516g(parcel, readInt);
                    break;
                case 6:
                    b5 = aur.m4514e(parcel, readInt);
                    break;
                case 7:
                    b4 = aur.m4514e(parcel, readInt);
                    break;
                case 8:
                    b3 = aur.m4514e(parcel, readInt);
                    break;
                case 9:
                    b2 = aur.m4514e(parcel, readInt);
                    break;
                case 10:
                    b = aur.m4514e(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
