package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class edt implements eds {
    public static Creator<edt> CREATOR = new C33261();
    @cga("count")
    Integer dEh;
    @cga("reposted")
    Boolean dEk;
    @cga("items")
    ArrayList<edc> uO;

    static class C33261 implements Creator<edt> {
        C33261() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10549L(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nc(i);
        }

        public edt m10549L(Parcel parcel) {
            return new edt(parcel);
        }

        public edt[] nc(int i) {
            return new edt[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.dEh);
        parcel.writeValue(this.dEk);
        parcel.writeList(this.uO);
    }

    private edt(Parcel parcel) {
        this.dEh = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dEk = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.uO = new ArrayList(5);
        parcel.readList(this.uO, edc.class.getClassLoader());
        if (this.uO.isEmpty()) {
            this.uO = null;
        }
    }
}
