package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.RawDataPoint;

public final class bau implements Creator<RawDataPoint> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        baf[] com_fossil_bafArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = aur.m4517h(parcel, readInt);
                    break;
                case 2:
                    j2 = aur.m4517h(parcel, readInt);
                    break;
                case 3:
                    com_fossil_bafArr = (baf[]) aur.m4510b(parcel, readInt, baf.CREATOR);
                    break;
                case 4:
                    i2 = aur.m4515f(parcel, readInt);
                    break;
                case 5:
                    i3 = aur.m4515f(parcel, readInt);
                    break;
                case 6:
                    j3 = aur.m4517h(parcel, readInt);
                    break;
                case 7:
                    j4 = aur.m4517h(parcel, readInt);
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
        return new RawDataPoint(i, j, j2, com_fossil_bafArr, i2, i3, j3, j4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new RawDataPoint[i];
    }
}
