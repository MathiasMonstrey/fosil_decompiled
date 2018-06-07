package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

public class eht implements ehs {
    public static final Creator<eht> CREATOR = new C34021();
    public Map<String, ehu> dHJ;

    static class C34021 implements Creator<eht> {
        C34021() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aL(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return od(i);
        }

        public eht aL(Parcel parcel) {
            return new eht(parcel);
        }

        public eht[] od(int i) {
            return new eht[i];
        }
    }

    public eht() {
        this.dHJ = new HashMap(2);
    }

    private eht(Parcel parcel) {
        this.dHJ = new HashMap(2);
        parcel.readMap(this.dHJ, ehu.class.getClassLoader());
    }

    public void mo2872a(ehu com_fossil_ehu) {
        this.dHJ.put(com_fossil_ehu.getName(), com_fossil_ehu);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.dHJ);
    }
}
