package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;

public final class bze implements Creator<byt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    latLng = (LatLng) aur.m4505a(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 4:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 5:
                    iBinder = aur.m4526q(parcel, readInt);
                    break;
                case 6:
                    f = aur.m4520k(parcel, readInt);
                    break;
                case 7:
                    f2 = aur.m4520k(parcel, readInt);
                    break;
                case 8:
                    z2 = aur.m4512c(parcel, readInt);
                    break;
                case 9:
                    z3 = aur.m4512c(parcel, readInt);
                    break;
                case 10:
                    z4 = aur.m4512c(parcel, readInt);
                    break;
                case 11:
                    f3 = aur.m4520k(parcel, readInt);
                    break;
                case 12:
                    f4 = aur.m4520k(parcel, readInt);
                    break;
                case 13:
                    f5 = aur.m4520k(parcel, readInt);
                    break;
                case 14:
                    f6 = aur.m4520k(parcel, readInt);
                    break;
                case 15:
                    f7 = aur.m4520k(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new byt(latLng, str, str2, iBinder, f, f2, z2, z3, z4, f3, f4, f5, f6, f7);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new byt[i];
    }
}
