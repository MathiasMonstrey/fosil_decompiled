package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class edq implements edp {
    public static Creator<edq> CREATOR = new C33251();
    @cga("count")
    Integer dEh;
    @cga("replied")
    Boolean dEi;
    @cga("reply_id")
    String dEj;
    @cga("items")
    ArrayList<edc> uO;

    static class C33251 implements Creator<edq> {
        C33251() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10548K(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nb(i);
        }

        public edq m10548K(Parcel parcel) {
            return new edq(parcel);
        }

        public edq[] nb(int i) {
            return new edq[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.dEh);
        parcel.writeValue(this.dEi);
        parcel.writeString(this.dEj);
        parcel.writeList(this.uO);
    }

    private edq(Parcel parcel) {
        this.dEh = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dEi = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.dEj = parcel.readString();
        this.uO = new ArrayList(5);
        parcel.readList(this.uO, edc.class.getClassLoader());
        if (this.uO.isEmpty()) {
            this.uO = null;
        }
    }
}
