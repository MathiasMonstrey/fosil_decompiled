package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ehr implements ehu<Integer> {
    public static final Creator<ehr> CREATOR = new C34011();
    private Integer dHI;

    static class C34011 implements Creator<ehr> {
        C34011() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aK(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return oc(i);
        }

        public ehr aK(Parcel parcel) {
            return new ehr(parcel);
        }

        public ehr[] oc(int i) {
            return new ehr[i];
        }
    }

    public /* synthetic */ Object getValue() {
        return aDi();
    }

    public /* synthetic */ void setValue(Object obj) {
        m10750d((Integer) obj);
    }

    private ehr(Parcel parcel) {
        this.dHI = Integer.valueOf(parcel.readInt());
    }

    public String getName() {
        return ehw.dHK;
    }

    public Integer aDi() {
        return this.dHI;
    }

    public void m10750d(Integer num) {
        this.dHI = num;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dHI.intValue());
    }
}
