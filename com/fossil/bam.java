package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

public final class bam implements Creator<DataSet> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        List list = null;
        int z2 = aur.m4535z(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        baa com_fossil_baa = null;
        int i = 0;
        while (parcel.dataPosition() < z2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    com_fossil_baa = (baa) aur.m4505a(parcel, readInt, baa.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) aur.m4505a(parcel, readInt, DataType.CREATOR);
                    break;
                case 3:
                    aur.m4508a(parcel, readInt, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    list = aur.m4511c(parcel, readInt, baa.CREATOR);
                    break;
                case 5:
                    z = aur.m4512c(parcel, readInt);
                    break;
                case 1000:
                    i = aur.m4515f(parcel, readInt);
                    break;
                default:
                    aur.m4509b(parcel, readInt);
                    break;
            }
        }
        aur.m4503D(parcel, z2);
        return new DataSet(i, com_fossil_baa, dataType, arrayList, list, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataSet[i];
    }
}
