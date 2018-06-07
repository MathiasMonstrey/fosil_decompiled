package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ehc implements ecd<Object> {
    public static Creator<ehc> CREATOR = new C33931();
    private final String href;

    static class C33931 implements Creator<ehc> {
        C33931() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aC(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nU(i);
        }

        public ehc aC(Parcel parcel) {
            return new ehc(parcel);
        }

        public ehc[] nU(int i) {
            return new ehc[i];
        }
    }

    public String getId() {
        return null;
    }

    public String getHref() {
        return this.href;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private ehc(Parcel parcel) {
        this.href = parcel.readString();
    }
}
