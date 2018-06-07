package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

public class ao extends SparseArray<Parcelable> implements Parcelable {
    public static final Creator<ao> CREATOR = ix.m11854a(new C17521());

    static class C17521 implements iy<ao> {
        C17521() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return m4064a(parcel, classLoader);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m4063E(i);
        }

        public ao m4064a(Parcel parcel, ClassLoader classLoader) {
            return new ao(parcel, classLoader);
        }

        public ao[] m4063E(int i) {
            return new ao[i];
        }
    }

    public ao(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        for (int i = 0; i < readInt; i++) {
            put(iArr[i], readParcelableArray[i]);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = keyAt(i2);
            parcelableArr[i2] = (Parcelable) valueAt(i2);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
