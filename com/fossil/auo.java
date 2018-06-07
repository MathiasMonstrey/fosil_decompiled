package com.fossil;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;

public final class auo implements Creator<DataHolder> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int z = aur.m4535z(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < z) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strArr = aur.m4534y(parcel, readInt);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) aur.m4510b(parcel, readInt, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = aur.m4515f(parcel, readInt);
                    break;
                case 4:
                    bundle = aur.m4527r(parcel, readInt);
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
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.KM();
        return dataHolder;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
