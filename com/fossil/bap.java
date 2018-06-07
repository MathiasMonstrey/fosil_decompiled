package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public final class bap implements Creator<DataType> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        int z = aur.m4535z(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = aur.m4525p(parcel, readInt);
                    break;
                case 2:
                    list = aur.m4511c(parcel, readInt, bac.CREATOR);
                    break;
                case 1000:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z);
        return new DataType(i, str, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataType[i];
    }
}
