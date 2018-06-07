package org.parceler.converter;

import android.os.Parcel;
import android.util.SparseArray;
import org.parceler.ParcelConverter;

public abstract class SparseArrayParcelConverter<T> implements ParcelConverter<SparseArray<T>> {
    public abstract T itemFromParcel(Parcel parcel);

    public abstract void itemToParcel(T t, Parcel parcel);

    public void toParcel(SparseArray<T> sparseArray, Parcel parcel) {
        if (sparseArray == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            parcel.writeInt(sparseArray.keyAt(i));
            itemToParcel(sparseArray.valueAt(i), parcel);
        }
    }

    public SparseArray<T> fromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        SparseArray<T> sparseArray = new SparseArray(readInt);
        for (int i = 0; i < readInt; i++) {
            sparseArray.append(parcel.readInt(), itemFromParcel(parcel));
        }
        return sparseArray;
    }
}
