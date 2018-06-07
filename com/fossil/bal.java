package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataPoint;

public final class bal implements Creator<DataPoint> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int z = aur.m4535z(parcel);
        int i = 0;
        baa com_fossil_baa = null;
        long j = 0;
        long j2 = 0;
        baf[] com_fossil_bafArr = null;
        baa com_fossil_baa2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    com_fossil_baa = (baa) aur.m4505a(parcel, readInt, baa.CREATOR);
                    break;
                case 3:
                    j = aur.m4517h(parcel, readInt);
                    break;
                case 4:
                    j2 = aur.m4517h(parcel, readInt);
                    break;
                case 5:
                    com_fossil_bafArr = (baf[]) aur.m4510b(parcel, readInt, baf.CREATOR);
                    break;
                case 6:
                    com_fossil_baa2 = (baa) aur.m4505a(parcel, readInt, baa.CREATOR);
                    break;
                case 7:
                    j3 = aur.m4517h(parcel, readInt);
                    break;
                case 8:
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
        return new DataPoint(i, com_fossil_baa, j, j2, com_fossil_bafArr, com_fossil_baa2, j3, j4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataPoint[i];
    }
}
