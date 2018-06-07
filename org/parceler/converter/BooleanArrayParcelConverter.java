package org.parceler.converter;

import android.os.Parcel;
import org.parceler.ParcelConverter;

public class BooleanArrayParcelConverter implements ParcelConverter<boolean[]> {
    private static final int NULL = -1;

    public void toParcel(boolean[] zArr, Parcel parcel) {
        if (zArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(zArr.length);
        parcel.writeBooleanArray(zArr);
    }

    public boolean[] fromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        parcel.readBooleanArray(zArr);
        return zArr;
    }
}
