package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class bmr implements Creator<bmq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int z2 = aur.m4535z(parcel);
        List list = bmq.bwt;
        boolean z3 = false;
        boolean z4 = false;
        String str2 = null;
        LocationRequest locationRequest = null;
        while (parcel.dataPosition() < z2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    locationRequest = (LocationRequest) aur.m4505a(parcel, readInt, LocationRequest.CREATOR);
                    break;
                case 5:
                    list = aur.m4511c(parcel, readInt, blu.CREATOR);
                    break;
                case 6:
                    str2 = aur.m4525p(parcel, readInt);
                    break;
                case 7:
                    z4 = aur.m4512c(parcel, readInt);
                    break;
                case 8:
                    z3 = aur.m4512c(parcel, readInt);
                    break;
                case 9:
                    z = aur.m4512c(parcel, readInt);
                    break;
                case 10:
                    str = aur.m4525p(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z2);
        return new bmq(locationRequest, list, str2, z4, z3, z, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bmq[i];
    }
}
