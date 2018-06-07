package com.misfit.frameworks.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum MisfitButtonEvent implements Parcelable {
    SINGLE_PRESS(19),
    DOUBLE_PRESS(20),
    TRIPLE_PRESS(21),
    LONG_PRESS(12),
    DOUBLE_PRESS_AND_HOLD(22),
    UNKNOWN(0);
    
    public static final Creator<MisfitButtonEvent> CREATOR = null;
    private int id;

    static class C47341 implements Creator<MisfitButtonEvent> {
        C47341() {
        }

        public MisfitButtonEvent createFromParcel(Parcel parcel) {
            return MisfitButtonEvent.getValue(parcel.readInt());
        }

        public MisfitButtonEvent[] newArray(int i) {
            return new MisfitButtonEvent[i];
        }
    }

    static {
        CREATOR = new C47341();
    }

    private MisfitButtonEvent(int i) {
        this.id = i;
    }

    public static MisfitButtonEvent getValue(int i) {
        for (MisfitButtonEvent misfitButtonEvent : values()) {
            if (misfitButtonEvent.equalsTo(i)) {
                return misfitButtonEvent;
            }
        }
        return UNKNOWN;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
    }

    public int describeContents() {
        return 0;
    }

    int getID() {
        return this.id;
    }

    public boolean equalsTo(int i) {
        return this.id == i;
    }
}
