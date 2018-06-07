package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.internal.PlaceEntity;

public final class bvo implements Creator<bvn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        PlaceEntity placeEntity = null;
        float f = 0.0f;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    placeEntity = (PlaceEntity) aur.m4505a(parcel, readInt, PlaceEntity.CREATOR);
                    break;
                case 2:
                    f = aur.m4520k(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new bvn(placeEntity, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new bvn[i];
    }
}
