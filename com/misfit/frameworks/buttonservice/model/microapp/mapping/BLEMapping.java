package com.misfit.frameworks.buttonservice.model.microapp.mapping;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.misfit.frameworks.common.enums.Gesture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BLEMapping implements Parcelable {
    public static Creator<BLEMapping> CREATOR = new 1();
    public static final String FIELD_TYPE = "mType";
    private final String className = getClass().getName();
    protected int mType;

    public abstract Gesture getGesture();

    protected abstract String getHash();

    public abstract boolean isNeedHID();

    public abstract boolean isNeedStreaming();

    public int describeContents() {
        return 0;
    }

    public BLEMapping(int i) {
        this.mType = i;
    }

    protected BLEMapping(Parcel parcel) {
        this.mType = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.className);
        parcel.writeInt(this.mType);
    }

    public int getType() {
        return this.mType;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BLEMapping)) {
            return false;
        }
        return getHash().equalsIgnoreCase(((BLEMapping) obj).getHash());
    }

    public static <A, B extends BLEMapping> boolean isMappingTheSame(List<A> list, List<B> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        List arrayList = new ArrayList(list);
        Collection arrayList2 = new ArrayList(list2);
        int size = arrayList.size();
        arrayList.retainAll(arrayList2);
        if (arrayList.size() == size) {
            return true;
        }
        return false;
    }
}
