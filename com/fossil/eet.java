package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class eet implements edl {
    public static Creator<eet> CREATOR = new C33551();
    @cga("key")
    String dFj;
    @cga("percentile")
    Double dFk;
    @cga("thumbnail_url")
    String dFl;

    static class C33551 implements Creator<eet> {
        C33551() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ah(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nx(i);
        }

        public eet ah(Parcel parcel) {
            return new eet(parcel);
        }

        public eet[] nx(int i) {
            return new eet[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dFj);
        parcel.writeValue(this.dFk);
        parcel.writeString(this.dFl);
    }

    private eet(Parcel parcel) {
        this.dFj = parcel.readString();
        this.dFk = (Double) parcel.readValue(Double.class.getClassLoader());
        this.dFl = parcel.readString();
    }
}
