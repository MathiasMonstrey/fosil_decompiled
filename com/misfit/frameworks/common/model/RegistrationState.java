package com.misfit.frameworks.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum RegistrationState implements Parcelable {
    STATE_REGISTERED(0),
    STATE_UNREGISTERED(1),
    STATE_UNKNOWN(-1);
    
    public static final Creator<RegistrationState> CREATOR = null;
    private int mId;

    static class C47371 implements Creator<RegistrationState> {
        C47371() {
        }

        public RegistrationState createFromParcel(Parcel parcel) {
            return RegistrationState.getValue(parcel.readInt());
        }

        public RegistrationState[] newArray(int i) {
            return new RegistrationState[i];
        }
    }

    static {
        CREATOR = new C47371();
    }

    private RegistrationState(int i) {
        this.mId = i;
    }

    public static RegistrationState getValue(int i) {
        for (RegistrationState registrationState : values()) {
            if (registrationState.mId == i) {
                return registrationState;
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
