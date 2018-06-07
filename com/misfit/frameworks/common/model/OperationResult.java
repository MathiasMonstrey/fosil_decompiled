package com.misfit.frameworks.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum OperationResult implements Parcelable {
    STATE_SUCCESSFUL(0),
    STATE_FAILED(1),
    STATE_REMOTE_UNREACHABLE(2),
    STATE_REMOTE_CONNECTION_LOST(3),
    STATE_NOT_REGISTERED(4),
    STATE_NOT_LOGGED_IN(5),
    STATE_UNKNOWN(-1);
    
    public static final Creator<OperationResult> CREATOR = null;
    private int mId;

    static class C47361 implements Creator<OperationResult> {
        C47361() {
        }

        public OperationResult createFromParcel(Parcel parcel) {
            return OperationResult.getValue(parcel.readInt());
        }

        public OperationResult[] newArray(int i) {
            return new OperationResult[i];
        }
    }

    static {
        CREATOR = new C47361();
    }

    private OperationResult(int i) {
        this.mId = i;
    }

    public static OperationResult getValue(int i) {
        for (OperationResult operationResult : values()) {
            if (operationResult.mId == i) {
                return operationResult;
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
