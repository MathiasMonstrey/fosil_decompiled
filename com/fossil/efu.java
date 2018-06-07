package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class efu implements eft {
    public static Creator<efu> CREATOR = new C33751();
    @cga("start_datetime")
    Date dGi;
    @cga("datetime")
    Date dGj;
    @cga("value")
    Map<String, Object> dGk;

    static class C33751 implements Creator<efu> {
        C33751() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aw(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return nM(i);
        }

        public efu aw(Parcel parcel) {
            return new efu(parcel);
        }

        public efu[] nM(int i) {
            return new efu[i];
        }
    }

    public efu() {
        this.dGk = new HashMap(4);
    }

    private efu(Parcel parcel) {
        this.dGk = new HashMap(4);
        this.dGi = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dGj = (Date) parcel.readValue(Date.class.getClassLoader());
        parcel.readMap(this.dGk, HashMap.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.dGi);
        parcel.writeValue(this.dGj);
        parcel.writeMap(this.dGk);
    }
}
