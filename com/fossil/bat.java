package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.MapValue;

public final class bat implements Creator<MapValue> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int z = aur.m4535z(parcel);
        float f = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 2:
                    f = aur.m4520k(parcel, readInt);
                    break;
                case 1000:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new MapValue(i2, i, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MapValue[i];
    }
}
