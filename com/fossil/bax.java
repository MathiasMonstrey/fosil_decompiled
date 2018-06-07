package com.fossil;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSet;

public final class bax implements Creator<baw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        IBinder iBinder = null;
        DataSet dataSet = null;
        int i = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    dataSet = (DataSet) aur.m4505a(parcel, readInt, DataSet.CREATOR);
                    break;
                case 2:
                    iBinder = aur.m4526q(parcel, readInt);
                    break;
                case 4:
                    z2 = aur.m4512c(parcel, readInt);
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
        return new baw(i, dataSet, iBinder, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new baw[i];
    }
}
