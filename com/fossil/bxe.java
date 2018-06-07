package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import com.misfit.frameworks.buttonservice.ButtonService;

public final class bxe implements Creator<LocationRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z2 = false;
        long j3 = ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    j = aur.m4517h(parcel, readInt);
                    break;
                case 3:
                    j2 = aur.m4517h(parcel, readInt);
                    break;
                case 4:
                    z2 = aur.m4512c(parcel, readInt);
                    break;
                case 5:
                    j3 = aur.m4517h(parcel, readInt);
                    break;
                case 6:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 7:
                    f = aur.m4520k(parcel, readInt);
                    break;
                case 8:
                    j4 = aur.m4517h(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new LocationRequest(i, j, j2, z2, j3, i2, f, j4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}
