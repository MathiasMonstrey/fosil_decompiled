package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ekl implements ekk {
    public static Creator<ekl> CREATOR = new C34371();
    @cga("weight")
    Double dKe;
    @cga("source")
    String source;

    static class C34371 implements Creator<ekl> {
        C34371() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return bl(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oJ(i);
        }

        public ekl bl(Parcel parcel) {
            return new ekl(parcel);
        }

        public ekl[] oJ(int i) {
            return new ekl[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.source);
        parcel.writeValue(this.dKe);
    }

    private ekl(Parcel parcel) {
        this.source = parcel.readString();
        this.dKe = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
