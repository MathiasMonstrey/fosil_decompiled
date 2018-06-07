package org.parceler.converter;

import android.os.Parcel;
import org.parceler.ParcelConverter;

public class CharArrayParcelConverter implements ParcelConverter<char[]> {
    private static final int NULL = -1;

    public void toParcel(char[] cArr, Parcel parcel) {
        if (cArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(cArr.length);
        parcel.writeCharArray(cArr);
    }

    public char[] fromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        char[] cArr = new char[readInt];
        parcel.readCharArray(cArr);
        return cArr;
    }
}
