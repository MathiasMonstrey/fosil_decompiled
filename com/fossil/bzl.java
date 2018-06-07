package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public final class bzl implements Creator<GoogleMapOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        byte b = (byte) -1;
        byte b2 = (byte) -1;
        int i = 0;
        CameraPosition cameraPosition = null;
        byte b3 = (byte) -1;
        byte b4 = (byte) -1;
        byte b5 = (byte) -1;
        byte b6 = (byte) -1;
        byte b7 = (byte) -1;
        byte b8 = (byte) -1;
        byte b9 = (byte) -1;
        byte b10 = (byte) -1;
        byte b11 = (byte) -1;
        Float f = null;
        Float f2 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    b = aur.m4514e(parcel, readInt);
                    break;
                case 3:
                    b2 = aur.m4514e(parcel, readInt);
                    break;
                case 4:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) aur.m4505a(parcel, readInt, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = aur.m4514e(parcel, readInt);
                    break;
                case 7:
                    b4 = aur.m4514e(parcel, readInt);
                    break;
                case 8:
                    b5 = aur.m4514e(parcel, readInt);
                    break;
                case 9:
                    b6 = aur.m4514e(parcel, readInt);
                    break;
                case 10:
                    b7 = aur.m4514e(parcel, readInt);
                    break;
                case 11:
                    b8 = aur.m4514e(parcel, readInt);
                    break;
                case 12:
                    b9 = aur.m4514e(parcel, readInt);
                    break;
                case 14:
                    b10 = aur.m4514e(parcel, readInt);
                    break;
                case 15:
                    b11 = aur.m4514e(parcel, readInt);
                    break;
                case 16:
                    f = aur.m4521l(parcel, readInt);
                    break;
                case 17:
                    f2 = aur.m4521l(parcel, readInt);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) aur.m4505a(parcel, readInt, LatLngBounds.CREATOR);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new GoogleMapOptions(b, b2, i, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11, f, f2, latLngBounds);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
