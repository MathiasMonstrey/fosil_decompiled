package com.misfit.frameworks.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum MisfitButtonState implements Parcelable {
    STATE_SUBSCRIBING(0),
    STATE_SUBSCRIBED(1),
    STATE_UNSUBSCRIBING(2),
    STATE_UNSUBSCRIBED(3),
    STATE_PAIRED(4),
    STATE_UNPAIRED(5),
    STATE_UNKNOWN(-1);
    
    public static final Creator<MisfitButtonState> CREATOR = null;
    private int mId;

    static class C47351 implements Creator<MisfitButtonState> {
        C47351() {
        }

        public MisfitButtonState createFromParcel(Parcel parcel) {
            return MisfitButtonState.getValue(parcel.readInt());
        }

        public MisfitButtonState[] newArray(int i) {
            return new MisfitButtonState[i];
        }
    }

    static {
        CREATOR = new C47351();
    }

    private MisfitButtonState(int i) {
        this.mId = i;
    }

    public static MisfitButtonState getValue(int i) {
        for (MisfitButtonState misfitButtonState : values()) {
            if (misfitButtonState.mId == i) {
                return misfitButtonState;
            }
        }
        return STATE_UNKNOWN;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
    }

    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.mId;
    }
}
